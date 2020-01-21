package com.hnineiphyu.onlineshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.onlineshop.R
import com.hnineiphyu.onlineshop.model.Country
import kotlinx.android.synthetic.main.choose_country.*

class CountryViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
    var countryName = itemView.findViewById<TextView>(R.id.country_name)
    var countryImage = itemView.findViewById<ImageView>(R.id.country_image)
}

class CountryAdapter(  var countryList: ArrayList<Country> ): RecyclerView.Adapter<CountryViewHolder>(){
    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.countryName.text = countryList[position].countryName
        holder.countryImage.setImageResource(countryList[position].countryImage)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.choose_country, parent, false)
        return CountryViewHolder(view)
    }

}