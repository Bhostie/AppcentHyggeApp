package com.hyggeapp.barisgokmen.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.hyggeapp.barisgokmen.data.network.RetrofitManager
import com.hyggeapp.barisgokmen.data.repository.ShoppingCartRepository

class ShoppingCartViewModel : ViewModel() {

    private val shoppingCartRepository = ShoppingCartRepository(RetrofitManager.shoppingCartService)
    val shoppingCartList = shoppingCartRepository.shoppingCartList

    fun fetchShoppingCart(cartId: Int) {
        shoppingCartRepository.getCart(cartId)
    }
    fun removeFromCart(cartId: Int, productId: Int?) {
        shoppingCartRepository.removeFromCart(cartId, productId)
    }
    fun clearCart(cartId: Int) {
        shoppingCartRepository.clearCart(cartId)
    }
}