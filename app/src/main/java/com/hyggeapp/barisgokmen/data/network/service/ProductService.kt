package com.hyggeapp.barisgokmen.data.network.service

import com.hyggeapp.barisgokmen.data.model.BaseResponse
import com.hyggeapp.barisgokmen.data.model.CartResponse
import com.hyggeapp.barisgokmen.data.model.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductService {

    @GET("products")
    fun getProducts(): Call<BaseResponse<List<Product>>>?

    @GET("products/{id}")
    fun getProductDetails(@Path("id") id: Int): Call<BaseResponse<Product>>?

}