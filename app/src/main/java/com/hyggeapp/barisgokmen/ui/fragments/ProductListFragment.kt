package com.hyggeapp.barisgokmen.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.hyggeapp.barisgokmen.data.model.Product
import com.hyggeapp.barisgokmen.databinding.FragmentProductListBinding
import com.hyggeapp.barisgokmen.ui.fragments.base.BaseFragment
import com.hyggeapp.barisgokmen.ui.adapters.recycler.productlist.ProductListRecyclerAdapter
import com.hyggeapp.barisgokmen.ui.adapters.recycler.RecyclerViewItemClickListener
import com.hyggeapp.barisgokmen.ui.viewmodels.ProductListViewModel

class ProductListFragment : BaseFragment<FragmentProductListBinding>() {

    private lateinit var viewModel: ProductListViewModel
    private lateinit var adapter: ProductListRecyclerAdapter

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentProductListBinding {
        return FragmentProductListBinding.inflate(inflater, container, false)
    }

    override fun initialize() {
        setViewModel()
        setRecyclerView()
        observeViewModel()
    }
    private fun setViewModel() {
        viewModel = ViewModelProvider(this).get(ProductListViewModel::class.java)
        viewModel.fetchProducts()
    }
    private fun observeViewModel() {
        viewModel.productList.observe(viewLifecycleOwner) { productList ->
            adapter.submitList(productList)
        }
    }

    private val recylerViewItemClickListener = object : RecyclerViewItemClickListener<Product?> {
        override fun onClick(item: Product?) {
            navigateToProductDetailsFragment(item)
        }
    }

    private fun navigateToProductDetailsFragment(product: Product?) {
        val action = ProductListFragmentDirections
                    .actionProductListFragmentToProductDetailFragment(product)
        findNavController().navigate(action)
    }

    private fun setRecyclerView() {
        adapter = ProductListRecyclerAdapter(recylerViewItemClickListener)
        binding?.rvProductlist?.layoutManager = GridLayoutManager(requireContext(), 2)
        binding?.rvProductlist?.adapter = adapter
    }
}