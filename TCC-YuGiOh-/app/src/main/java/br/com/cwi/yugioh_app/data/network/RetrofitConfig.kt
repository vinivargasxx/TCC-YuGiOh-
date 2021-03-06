package br.com.cwi.yugioh_app.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitConfig {

    val SERVICE: YugiohApi = Retrofit.Builder()
        .baseUrl("https://db.ygoprodeck.com/api/v7/cardinfo.php/")
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder()
                    .addLast(KotlinJsonAdapterFactory())
                    .build()
            )
        )
        .build()
        .create(YugiohApi::class.java)
}