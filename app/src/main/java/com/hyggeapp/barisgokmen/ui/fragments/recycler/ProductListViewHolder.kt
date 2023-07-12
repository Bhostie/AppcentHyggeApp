package com.hyggeapp.barisgokmen.ui.fragments.recycler

import androidx.recyclerview.widget.RecyclerView
import com.hyggeapp.barisgokmen.data.model.Product
import com.hyggeapp.barisgokmen.databinding.ItemProductBinding
import com.squareup.picasso.Picasso

class ProductListViewHolder(
    private val binding: ItemProductBinding,
    private val recylerViewItemClickListener: RecyclerViewItemClickListener<Product?>?
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Product?) {
        binding.tvProductName.text = "${item?.productName}"
        binding.tvNewPrice.text = "$${item?.newPrice}"
        binding.tvOldPrice.text = "$${item?.oldPrice}"
        binding.tvType.text = "${item?.type}"
        Picasso
            .get()
            .load(item?.productImage)
            .into(binding.ivProduct)

        binding.root.setOnClickListener {
            recylerViewItemClickListener?.onClick(item)
        }
    }


}