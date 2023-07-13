package com.hyggeapp.barisgokmen.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hyggeapp.barisgokmen.R
import com.hyggeapp.barisgokmen.data.model.Product
import com.hyggeapp.barisgokmen.databinding.FragmentProductDetailBinding
import com.hyggeapp.barisgokmen.ui.fragments.base.BaseFragment
import com.hyggeapp.barisgokmen.ui.viewmodels.ProductDetailViewModel
import com.hyggeapp.barisgokmen.util.DialogHelper
import com.squareup.picasso.Picasso


class ProductDetailFragment : BaseFragment<FragmentProductDetailBinding>() {

    private lateinit var viewModel: ProductDetailViewModel
    private val args: ProductDetailFragmentArgs by navArgs()
    private var product: Product? = null
    private lateinit var dialogHelper: DialogHelper

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
        setDialog()
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
            showDialog()
        }
    }
    private fun locationButtonListener() {
        binding?.btnLocation?.setOnClickListener {
        TODO("Not yet implemented")
        }
    }
    private fun setDialog(){
        dialogHelper = DialogHelper()
    }
    private fun showDialog(){
        val action = ProductDetailFragmentDirections.actionProductDetailFragmentToProductListFragment()
        val dialog = dialogHelper.createCustomDialog(requireContext(),
                    R.string.added_to_cart,
                    findNavController(),
                    action,)
        dialog.show()
    }



}