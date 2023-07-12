package com.hyggeapp.barisgokmen.data.network

import com.hyggeapp.barisgokmen.BuildConfig
import com.hyggeapp.barisgokmen.data.network.service.ProductService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitManager {

    private lateinit var retrofit: Retrofit
    lateinit var productService: ProductService
    private val BASE_API_URL = "http://159.223.0.153/"

    init {
        retrofitBuilder()
        bindServices()
    }
    private fun retrofitBuilder() {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_API_URL)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun bindServices() {
        productService = retrofit.create(ProductService::class.java)
    }
    private fun getOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(60, TimeUnit.SECONDS)
        httpClient.addInterceptor(createHttpLoggingInterceptor())

        return httpClient.build()
    }
    private fun createHttpLoggingInterceptor() : HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        return httpLoggingInterceptor
    }
}