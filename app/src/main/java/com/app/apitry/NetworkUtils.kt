package com.app.apitry

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils{

    companion object{

        fun getRetrofitInstance(caminho: String): Retrofit {

            return Retrofit.Builder()
                .baseUrl(caminho)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}