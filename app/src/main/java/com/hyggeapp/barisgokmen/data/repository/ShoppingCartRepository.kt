package com.hyggeapp.barisgokmen.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hyggeapp.barisgokmen.data.model.BaseResponse
import com.hyggeapp.barisgokmen.data.model.CartResponse
import com.hyggeapp.barisgokmen.data.model.Product
import com.hyggeapp.barisgokmen.data.network.service.ShoppingCartService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShoppingCartRepository(private val productApiService: ShoppingCartService) {

    private val _shoppingCartList = MutableLiveData<List<Product>?>()
    val shoppingCartList: LiveData<List<Product>?> = _shoppingCartList

    fun addToCart(cartId: Int, productId: Int) {
        productApiService.addToCart(cartId, productId)?.enqueue(object : Callback<BaseResponse<CartResponse>> {
            override fun onResponse(
                call: Call<BaseResponse<CartResponse>>,
                response: Response<BaseResponse<CartResponse>>
            ) {
                if (response.isSuccessful) {
                    val cartList = response.body()?.result
                    _shoppingCartList.value = cartList?.products
                }
            }
            override fun onFailure(call: Call<BaseResponse<CartResponse>>, t: Throwable) {
                Log.d("addToCart", "onFailure: ${t.message}")
            }
        })
    }
    fun getCart(cartId: Int) {
        productApiService.getCart(cartId)?.enqueue(object : Callback<BaseResponse<CartResponse>> {
            override fun onResponse(
                call: Call<BaseResponse<CartResponse>>,
                response: Response<BaseResponse<CartResponse>>
            ) {
                if (response.isSuccessful) {
                    val cartList = response.body()?.result
                    _shoppingCartList.value = cartList?.products
                }
            }
            override fun onFailure(call: Call<BaseResponse<CartResponse>>, t: Throwable) {
                Log.d("getCart", "onFailure: ${t.message}")
            }
        })
    }
    fun removeFromCart(cartId: Int, productId: Int?) {
        productApiService.removeProduct(cartId, productId)?.enqueue(object : Callback<BaseResponse<CartResponse>> {
            override fun onResponse(
                call: Call<BaseResponse<CartResponse>>,
                response: Response<BaseResponse<CartResponse>>
            ) {
                if (response.isSuccessful) {
                    val cartList = response.body()?.result
                    _shoppingCartList.value = cartList?.products
                }
            }
            override fun onFailure(call: Call<BaseResponse<CartResponse>>, t: Throwable) {
                Log.d("removeProduct", "onFailure: ${t.message}")
            }
        })
    }
    fun clearCart(cartId: Int) {
        productApiService.clearCart(cartId)?.enqueue(object : Callback<BaseResponse<CartResponse>> {
            override fun onResponse(
                call: Call<BaseResponse<CartResponse>>,
                response: Response<BaseResponse<CartResponse>>
            ) {
                if (response.isSuccessful) {
                    val cartList = response.body()?.result
                    _shoppingCartList.value = cartList?.products
                }
            }
            override fun onFailure(call: Call<BaseResponse<CartResponse>>, t: Throwable) {
                Log.d("clearCart", "onFailure: ${t.message}")
            }
        })
    }
}