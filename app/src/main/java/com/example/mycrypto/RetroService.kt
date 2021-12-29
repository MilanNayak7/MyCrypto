package com.example.mycrypto

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET


var BASE_URL = "https://pro-api.coinmarketcap.com/v1/"
interface RetroService {

    @GET("cryptocurrency/listings/latest?CMC_PRO_API_KEY=73c85002-c2c8-4057-8e78-8908e05e637c")
    fun getCrypto():Call<Crypto>
}
object NewService{
    val cryptoInstance:RetroService
    init {
        val retrofit  = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        cryptoInstance = retrofit.create(RetroService::class.java)
    }
}
