package com.hyggeapp.barisgokmen.data.network.service

import com.hyggeapp.barisgokmen.data.model.BaseResponse
import com.hyggeapp.barisgokmen.data.model.CartResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ShoppingCartService {
    @GET("cart/{id}")
    fun getCart(@Path("id") id: Int): Call<BaseResponse<CartResponse>>?

    @POST("addtocart/{cart_id}/{product_id}")
    fun addToCart(@Path("cart_id") cartId: Int, @Path("product_id") productId: Int): Call<BaseResponse<CartResponse>>?

}