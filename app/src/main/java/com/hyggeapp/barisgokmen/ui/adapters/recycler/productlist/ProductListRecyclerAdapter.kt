package com.hyggeapp.barisgokmen.ui.adapters.recycler.productlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hyggeapp.barisgokmen.data.model.Product
import com.hyggeapp.barisgokmen.databinding.ItemProductBinding
import com.hyggeapp.barisgokmen.ui.adapters.recycler.RecyclerViewItemClickListener

class ProductListRecyclerAdapter(
    private val recylerViewItemClickListener: RecyclerViewItemClickListener<Product?>?
) : ListAdapter<Product, ProductListViewHolder>(ProductListDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return ProductListViewHolder(binding,recylerViewItemClickListener)
    }
    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
    class ProductListDiffUtil : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
}