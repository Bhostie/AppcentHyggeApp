package com.hyggeapp.barisgokmen.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.hyggeapp.barisgokmen.data.model.Product
import com.hyggeapp.barisgokmen.databinding.FragmentProductDetailBinding
import com.hyggeapp.barisgokmen.ui.fragments.base.BaseFragment
import com.hyggeapp.barisgokmen.ui.viewmodels.ProductDetailViewModel
import com.hyggeapp.barisgokmen.ui.viewmodels.ProductListViewModel
import com.squareup.picasso.BuildConfig
import com.squareup.picasso.Picasso


class ProductDetailFragment : BaseFragment<FragmentProductDetailBinding>() {

    private lateinit var viewModel: ProductDetailViewModel
    private val args: ProductDetailFragmentArgs by navArgs()
    private var product: Product? = null


    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentProductDetailBinding {
        return FragmentProductDetailBinding.inflate(inflater, container, false)
    }

    override fun initialize() {
        product = args.clickedProduct
        setProductDetail()
        setViewModel()
        addToCartButtonListener()

    }
    private fun setViewModel() {
        viewModel = ViewModelProvider(this).get(ProductDetailViewModel::class.java)
    }
    private fun setProductDetail() {
        binding?.tvProductName?.text = product?.productName
        binding?.tvProductPrice?.text = "\$${product?.newPrice}"
        Picasso.get().load(product?.productImage).into(binding?.ivProductImage)
    }
    private fun addToCartButtonListener() {
        binding?.btnAddToCart?.setOnClickListener {
            viewModel.addToCart(9, product?.id ?: 0)
        }
        // TODO: "Added to Cart" popup
    }
    private fun locationButtonListener() {
        binding?.btnLocation?.setOnClickListener {
        TODO("Not yet implemented")
        }
    }
}