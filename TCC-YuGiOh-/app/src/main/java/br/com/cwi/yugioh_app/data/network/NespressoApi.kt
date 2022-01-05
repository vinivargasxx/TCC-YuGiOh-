package br.com.cwi.yugioh_app.data.network

import br.com.cwi.yugioh_app.data.network.entity.CardResponse
import retrofit2.http.GET

interface NespressoApi {

    @GET
    suspend fun getCards(): List<CardResponse>

}