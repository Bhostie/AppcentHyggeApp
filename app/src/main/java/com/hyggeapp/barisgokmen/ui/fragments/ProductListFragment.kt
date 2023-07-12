package com.hyggeapp.barisgokmen.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.hyggeapp.barisgokmen.R
import com.hyggeapp.barisgokmen.databinding.FragmentProductListBinding
import com.hyggeapp.barisgokmen.ui.fragments.base.BaseFragment
import com.hyggeapp.barisgokmen.ui.fragments.recycler.ProductListRecyclerAdapter
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
        viewModel = ViewModelProvider(this).get(ProductListViewModel::class.java)
        viewModel.fetchProducts()
        adapter = ProductListRecyclerAdapter()

        binding?.rvProductlist?.layoutManager = GridLayoutManager(requireContext(), 2)
        binding?.rvProductlist?.adapter = adapter

        viewModel.productList.observe(viewLifecycleOwner) { productList ->
            adapter.submitList(productList)
        }


    }


}