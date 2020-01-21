package com.hnineiphyu.onlineshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.onlineshop.R
import com.hnineiphyu.onlineshop.model.Arrival
import com.hnineiphyu.onlineshop.model.Product

class ArrivialViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
    var firstName = itemView.findViewById<TextView>(R.id.name_one_arrival)
    var secondName = itemView.findViewById<TextView>(R.id.name_two_arrival)
    var brand = itemView.findViewById<TextView>(R.id.quality_arrival)
    var rate = itemView.findViewById<RatingBar>(R.id.rate_bar)
    var price = itemView.findViewById<TextView>(R.id.price_arrival)
    var image = itemView.findViewById<ImageView>(R.id.image_arrival)
    var strikes = itemView.findViewById<TextView>(R.id.strikes)

    fun bind(arrival: Arrival, clickListener: OnItemClickListener){
        itemView.setOnClickListener{
            clickListener.OnItemClicked(arrival)
        }
    }
}

class ArrivalAdapter (var arrivalList: ArrayList<Arrival>,  val itemClickListener: OnItemClickListener):RecyclerView.Adapter<ArrivialViewHolder>(){
    override fun onBindViewHolder(holder: ArrivialViewHolder, position: Int) {
        holder.firstName.text = arrivalList[position].firstName
        holder.secondName.text = arrivalList[position].secondName
        holder.brand.text = arrivalList[position].brand
        holder.rate.rating = arrivalList[position].rating.toFloat()
        holder.price.text = arrivalList[position].price.toString()
        holder.image.setImageResource(arrivalList[position].image)
        holder.strikes.text = arrivalList[position].strikes
        holder.bind(arrivalList[position], itemClickListener)
    }

    override fun getItemCount(): Int {
        return arrivalList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArrivialViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.latest_arrivals,parent,false)
        return ArrivialViewHolder(view)
    }

}
interface OnItemClickListener {
    fun OnItemClicked(arrival: Arrival )
}