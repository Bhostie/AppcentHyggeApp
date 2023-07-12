package com.hyggeapp.barisgokmen.ui.fragments.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<T : ViewBinding> : Fragment(){

    private var _binding: T? = null
    protected val binding get() = _binding

    abstract fun setBinding(inflater: LayoutInflater,
                            container: ViewGroup?,
                            savedInstanceState: Bundle?): T

    abstract fun initialize()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = setBinding(inflater, container, savedInstanceState)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

