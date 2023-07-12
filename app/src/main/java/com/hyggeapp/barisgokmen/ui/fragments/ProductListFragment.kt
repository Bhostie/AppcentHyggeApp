package com.hyggeapp.barisgokmen.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyggeapp.barisgokmen.R
import com.hyggeapp.barisgokmen.databinding.FragmentProductListBinding
import com.hyggeapp.barisgokmen.ui.fragments.base.BaseFragment
import com.hyggeapp.barisgokmen.ui.viewmodels.ProductListViewModel

class ProductListFragment : BaseFragment<FragmentProductListBinding>() {

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentProductListBinding {
        return FragmentProductListBinding.inflate(inflater, container, false)
    }

    override fun initialize() {
        val viewModel = ViewModelProvider(this).get(ProductListViewModel::class.java)

    }


}