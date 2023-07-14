package com.hyggeapp.barisgokmen.ui.adapters.recycler.shoppingcart

import androidx.recyclerview.widget.RecyclerView
import com.hyggeapp.barisgokmen.data.model.Product
import com.hyggeapp.barisgokmen.databinding.ItemCartBinding
import com.hyggeapp.barisgokmen.ui.adapters.recycler.RecyclerViewItemClickListener
import com.squareup.picasso.Picasso

class ShoppingCartViewHolder(
    private val binding: ItemCartBinding,
    private val recylerViewItemClickListener: RecyclerViewItemClickListener<Product?>?
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Product?) {
        binding.tvProductName.text = "${item?.productName}"
        binding.tvPrice.text = "$${item?.newPrice}"
        Picasso
            .get()
            .load(item?.productImage)
            .into(binding.ivProductImage)

        binding.ibRemove.setOnClickListener {
            recylerViewItemClickListener?.onClick(item)
        }
    }
}