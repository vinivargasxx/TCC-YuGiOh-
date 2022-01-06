package br.com.cwi.yugioh_app.data.network

import br.com.cwi.yugioh_app.data.network.entity.DataResponse
import retrofit2.http.GET

interface YugiohApi {

    @GET
    suspend fun getCards(): List<DataResponse>

}