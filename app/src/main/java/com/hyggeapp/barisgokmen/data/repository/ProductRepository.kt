package com.hyggeapp.barisgokmen.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hyggeapp.barisgokmen.data.model.BaseResponse
import com.hyggeapp.barisgokmen.data.model.Product
import com.hyggeapp.barisgokmen.data.network.service.ProductService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository(private val productApiService: ProductService) {

    private val _productList = MutableLiveData<List<Product>?>()
    val productList: LiveData<List<Product>?> = _productList

    fun fetchProducts() {
        productApiService.getProducts()?.enqueue(object : Callback<BaseResponse<List<Product>>> {
            override fun onResponse(
                call: Call<BaseResponse<List<Product>>>,
                response: Response<BaseResponse<List<Product>>>
            ) {
                if (response.isSuccessful) {
                    val products = response.body()?.result
                    _productList.value = products
                }
            }

            override fun onFailure(call: Call<BaseResponse<List<Product>>>, t: Throwable) {
                Log.d("ProductRepository", "onFailure: ${t.message}")
            }
        })
    }

}