package com.hnineiphyu.onlineshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.onlineshop.R
import com.hnineiphyu.onlineshop.model.Arrival
import com.hnineiphyu.onlineshop.model.Product


class PopularViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
    var name = itemView.findViewById<TextView>(R.id.txt_product_name)
    var brand = itemView.findViewById<TextView>(R.id.brand_name)
    var price = itemView.findViewById<TextView>(R.id.price_popular)
    var new = itemView.findViewById<Button>(R.id.btn_new)
    var discount = itemView.findViewById<Button>(R.id.btn_discount)
    var image = itemView.findViewById<ImageView>(R.id.popular_image)
    var rate = itemView.findViewById<RatingBar>(R.id.rate_bar)
    var strike = itemView.findViewById<TextView>(R.id.strike)
    }


class PopularAdapter (var productList: ArrayList<Product> ): RecyclerView.Adapter<PopularViewHolder>(){

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.name.text = productList[position].name
        holder.brand.text = productList[position].brand
        holder.price.text = productList[position].price.toString()
        holder.rate.rating = productList[position].rating.toFloat()
        holder.strike.text = productList[position].strike
        holder.new.text = productList[position].new
        holder.discount.text = productList[position].discount
        holder.image.setImageResource(productList[position].image)

        if(productList[position].new == "0"){
            holder.new.visibility = View.INVISIBLE
        }

        if(productList[position].discount == "0"){
            holder.discount.visibility = View.INVISIBLE
        }

    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.popular_product, parent, false)
        return PopularViewHolder(view)

    }

}


