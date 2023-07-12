package com.hyggeapp.barisgokmen.ui.fragments.recycler

import androidx.recyclerview.widget.RecyclerView
import com.hyggeapp.barisgokmen.data.model.Product
import com.hyggeapp.barisgokmen.databinding.ItemProductBinding
import com.squareup.picasso.Picasso

class ProductListViewHolder(
    private val binding: ItemProductBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Product?) {
        binding.tvProductName.text = "${item?.productName}"
        binding.tvNewPrice.text = "${item?.newPrice} TL"
        binding.tvOldPrice.text = "${item?.oldPrice} TL"
        binding.tvType.text = "${item?.type}"
        Picasso
            .get()
            .load(item?.productImage)
            .into(binding.ivProduct)
    }

}