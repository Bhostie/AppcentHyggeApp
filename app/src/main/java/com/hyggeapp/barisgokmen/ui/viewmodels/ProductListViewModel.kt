package com.hyggeapp.barisgokmen.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hyggeapp.barisgokmen.data.model.Product
import com.hyggeapp.barisgokmen.data.network.RetrofitManager
import com.hyggeapp.barisgokmen.data.repository.ProductRepository

class ProductListViewModel : ViewModel() {

    private val productRepository = ProductRepository(RetrofitManager.productService)
    val productList: LiveData<List<Product>?> = productRepository.productList


    fun fetchProducts() {
        productRepository.fetchProducts()
    }

}