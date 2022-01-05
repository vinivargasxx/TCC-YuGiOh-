package br.com.cwi.yugioh_app.presentation.feature.products.card

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.cwi.yugioh_app.data.database.mapper.toEntity
import br.com.cwi.yugioh_app.domain.entity.Card
import br.com.cwi.yugioh_app.domain.repository.CardLocalRepository
import br.com.cwi.yugioh_app.domain.repository.CardRepository
import br.com.cwi.yugioh_app.extensions.test
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
@ExperimentalCoroutinesApi
class CardViewModelTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    private lateinit var viewModel: CardViewModel

    private val cardRepository: CardRepository = mockk()
    private val cardLocalRepository: CardLocalRepository = mockk()

    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = CardViewModel(cardRepository, cardLocalRepository)
    }

    @Test
    fun givenCoffee_whenIsFavorite_thenSaveToLocalRepository() {
        // Arrange
        val coffee = Card(
            id = 1,
            name = "Café",
            urlImage = "",
            unitPrice = 1.0,
            description = "description",
            intensity = 10,
            measures = listOf("longo", "forte"),
            isDeck = true
        )
        every { cardLocalRepository.add(coffee.toEntity()) } returns Unit

        // Act
        viewModel.setFavorite(coffee)

        // Assert
        verify { cardLocalRepository.add(coffee.toEntity()) }
    }

    @Test
    fun givenCoffee_whenIsNotFavorite_thenRemoveFromLocalRepository() {
        // Arrange
        val coffee = Card(
            id = 1,
            name = "Café",
            urlImage = "",
            unitPrice = 1.0,
            description = "description",
            intensity = 10,
            measures = listOf("longo", "forte"),
            isDeck = false
        )
        every { cardLocalRepository.remove(coffee.toEntity()) } returns Unit

        // Act
        viewModel.setFavorite(coffee)

        // Assert
        verify { cardLocalRepository.remove(coffee.toEntity()) }
    }

    @Test
    fun whenFetchCoffees_thenReturnCoffeeSuccessfully() {
        // Arrange
        val coffeeObserver = viewModel.cards.test()
        val categoryList = listOf(
            Data(
                category = "Category",
                products = emptyList(),
            )
        )
        coEvery { cardRepository.getCards() } returns categoryList
        coEvery { cardLocalRepository.getAll() } returns emptyList()

        // Act
        viewModel.fetchCoffees()

        // Assert
        verify { cardLocalRepository.getAll() }
        verify { coffeeObserver.onChanged(any()) }
    }
}

