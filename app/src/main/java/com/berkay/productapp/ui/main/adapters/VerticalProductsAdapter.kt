package com.berkay.productapp.ui.main.adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.berkay.productapp.R
import com.berkay.productapp.data.model.Product
import com.berkay.productapp.utils.StringUtils.toPriceString
import com.bumptech.glide.Glide

class VerticalProductsAdapter(private val products : ArrayList<Product>, private val context: Context) :
    RecyclerView.Adapter<VerticalProductsAdapter.VerticalProductsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalProductsHolder {
        val v: View =
            LayoutInflater.from(context).inflate(R.layout.cardviewproduct, parent, false)

        return VerticalProductsHolder(v)
    }
    var onItemClick: ((Product) -> Unit)? = null

    override fun onBindViewHolder(holder: VerticalProductsHolder, position: Int) {
        holder.setData(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class VerticalProductsHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private var imgProduct : ImageView
        private var txtTitle : TextView
        private var txtPrice : TextView

        init {
            imgProduct = itemView.findViewById<View>(R.id.imgProduct) as ImageView
            txtTitle = itemView.findViewById<View>(R.id.txtTitle) as TextView
            txtPrice = itemView.findViewById<View>(R.id.txtPrice) as TextView
        }

        fun setData(
            product : Product
        ) {
            Glide.with(context)
                .load(product.image)
                .into(imgProduct);
            txtTitle.text = product.title
            txtPrice.text = product.price.toPriceString()
            itemView.setOnClickListener {
                onItemClick?.invoke(product)
            }
        }
    }
}