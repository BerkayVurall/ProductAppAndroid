package com.berkay.productapp.data.api

import com.berkay.productapp.constants.Global
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {

    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if (retrofit == null){
            val okHttpClient = OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
            val client = okHttpClient.build()

            val gson = GsonBuilder()
                .setLenient()
                .create();
            retrofit =
                    Retrofit.Builder().client(client).baseUrl(Global.baseUrl)
                        .addConverterFactory(
                            GsonConverterFactory.create(gson)).build()

        }
        return retrofit as Retrofit
    }

}