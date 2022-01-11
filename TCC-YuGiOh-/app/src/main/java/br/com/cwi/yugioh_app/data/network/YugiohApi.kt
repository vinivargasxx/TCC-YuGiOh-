package br.com.cwi.yugioh_app.data.network

import br.com.cwi.yugioh_app.data.network.entity.DataResponse
import retrofit2.http.GET
import retrofit2.http.Query

const val ITENS_PAGINA = 6

interface YugiohApi {

    @GET("?num=${ITENS_PAGINA}")
    suspend fun getCards(@Query("offset") offset: Int): DataResponse

}