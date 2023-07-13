package com.hyggeapp.barisgokmen.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hyggeapp.barisgokmen.R
import com.hyggeapp.barisgokmen.data.model.Product
import com.hyggeapp.barisgokmen.databinding.FragmentShoppingCartBinding
import com.hyggeapp.barisgokmen.ui.fragments.base.BaseFragment
import com.hyggeapp.barisgokmen.ui.fragments.recycler.RecyclerViewItemClickListener
import com.hyggeapp.barisgokmen.ui.fragments.recycler.productlist.ProductListRecyclerAdapter
import com.hyggeapp.barisgokmen.ui.fragments.recycler.shoppingcart.ShoppingCartRecyclerAdapter
import com.hyggeapp.barisgokmen.ui.viewmodels.ShoppingCartViewModel
import com.hyggeapp.barisgokmen.util.DialogHelper

class ShoppingCartFragment : BaseFragment<FragmentShoppingCartBinding>() {

    private lateinit var viewModel: ShoppingCartViewModel
    private lateinit var adapter: ShoppingCartRecyclerAdapter
    private lateinit var dialogHelper: DialogHelper

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentShoppingCartBinding {
        return FragmentShoppingCartBinding.inflate(inflater, container, false)
    }

    override fun initialize() {
        setViewModel()
        observeViewModel()
        setRecyclerView()
        buyButtonListener()
        setDialog()
    }
    private fun setViewModel() {
        viewModel = ViewModelProvider(this).get(ShoppingCartViewModel::class.java)
        viewModel.fetchShoppingCart(9)
    }
    private fun observeViewModel() {
        viewModel.shoppingCartList.observe(viewLifecycleOwner) { productList ->
            adapter.submitList(productList)
        }
    }
    private val recylerViewItemClickListener = object : RecyclerViewItemClickListener<Product?> {
        override fun onClick(item: Product?) {
            viewModel.removeFromCart(9, item?.id)
        }
    }

    private fun setRecyclerView() {
        adapter = ShoppingCartRecyclerAdapter(recylerViewItemClickListener)
        binding?.rvProductlist?.layoutManager = LinearLayoutManager(requireContext())
        binding?.rvProductlist?.adapter = adapter
    }
    private fun buyButtonListener() {
        binding?.btnBuy?.setOnClickListener {
            viewModel.clearCart(9)
            showDialog()
        }
    }

    private fun setDialog(){
        dialogHelper = DialogHelper()
    }
    private fun showDialog(){
        val action = ShoppingCartFragmentDirections.actionShoppingCartFragmentToProductListFragment()
        val dialog = dialogHelper.createCustomDialog(requireContext(),
            R.string.buy_success,
            findNavController(),
            action)
        dialog.show()
    }



}