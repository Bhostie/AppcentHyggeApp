package com.hyggeapp.barisgokmen.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hyggeapp.barisgokmen.data.model.Product
import com.hyggeapp.barisgokmen.data.network.RetrofitManager
import com.hyggeapp.barisgokmen.data.repository.ShoppingCartRepository

class ProductDetailViewModel : ViewModel() {

    private val shoppingCartRepository = ShoppingCartRepository(RetrofitManager.shoppingCartService)
    val shoppingCartList : LiveData<List<Product>?> = shoppingCartRepository.shoppingCartList

    fun fetchShoppingCart(cartId: Int) {
        shoppingCartRepository.getCart(cartId)
    }
    fun addToCart(cartId: Int, productId: Int) {
        shoppingCartRepository.addToCart(cartId, productId)
    }
}