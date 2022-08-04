package com.example.taskinternshala.ui.productlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taskinternshala.R
import com.example.taskinternshala.application.TaskApp
import com.example.taskinternshala.databinding.ItemRecyclerviewBinding
import com.example.taskinternshala.model.ProductsItem

class ProductListAdapter ( private var list: List<ProductsItem>) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

   inner class ProductViewHolder(private val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(productsItem: ProductsItem){
            binding.apply {
                tvProductName.text = productsItem.product_name
                tvProductType.text = productsItem.product_type
                tvProductPrice.text = "₹${productsItem.price}"
                tvProductTax.text = "Tax :".plus(productsItem.tax).plus("%")
                Glide.with(TaskApp.instance)
                    .load(productsItem.image)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(ivImg)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(ItemRecyclerviewBinding.inflate(LayoutInflater.
        from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val productsItem = list[position]
        holder.bind(productsItem)
    }

    override fun getItemCount(): Int {
       return list.size
    }
}


