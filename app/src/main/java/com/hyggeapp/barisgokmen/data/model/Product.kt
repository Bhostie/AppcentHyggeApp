package com.hyggeapp.barisgokmen.data.model


import com.google.gson.annotations.SerializedName


data class Product(

	@field:SerializedName("productImage")
	val productImage: String? = null,

	@field:SerializedName("quantity")
	val quantity: Int? = null,

	@field:SerializedName("oldPrice")
	val oldPrice: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("currentStore")
	val currentStore: Any? = null,

	@field:SerializedName("newPrice")
	val newPrice: Any? = null,

	@field:SerializedName("productName")
	val productName: String? = null
)