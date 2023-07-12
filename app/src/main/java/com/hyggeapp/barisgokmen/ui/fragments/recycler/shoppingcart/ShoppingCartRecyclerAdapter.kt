package com.hyggeapp.barisgokmen.ui.fragments.recycler.shoppingcart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hyggeapp.barisgokmen.data.model.Product
import com.hyggeapp.barisgokmen.databinding.ItemCartBinding
import com.hyggeapp.barisgokmen.ui.fragments.recycler.RecyclerViewItemClickListener

class ShoppingCartRecyclerAdapter(
    private val recylerViewItemClickListener: RecyclerViewItemClickListener<Product?>?

) : ListAdapter<Product, ShoppingCartViewHolder>(ShoppingCartDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCartViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCartBinding.inflate(inflater, parent, false)
        return ShoppingCartViewHolder(binding,recylerViewItemClickListener)
    }

    override fun onBindViewHolder(holder: ShoppingCartViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    class ShoppingCartDiffUtil : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
}