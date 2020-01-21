package com.hnineiphyu.onlineshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hnineiphyu.onlineshop.adapter.*
import com.hnineiphyu.onlineshop.model.Arrival
import com.hnineiphyu.onlineshop.model.Country
import com.hnineiphyu.onlineshop.model.Product
import java.util.ArrayList

class MainActivity : AppCompatActivity(),OnItemClickListener {

    override fun OnItemClicked(arrival: Arrival) {

        Toast.makeText(this, "${arrival.brand}", Toast.LENGTH_LONG).show()

        val intent = Intent(this, CartActivity::class.java).apply {

            putExtra("ARRIVAL_FIRST_NAME", arrival.firstName)
            putExtra("ARRIVAL_SECOND_NAME", arrival.secondName)
            putExtra("ARRIVAL_BRAND", arrival.brand)
            putExtra("ARRIVAL_PRICE", arrival.price)
            putExtra("ARRIVAL_IMAGE", arrival.image)

        }

        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        latestArrival()
        chooseCountry()
        popularProduct()
    }

        fun latestArrival(){

            var arrivalRecyclerView: RecyclerView = findViewById(R.id.recycler_arrival)

            var arrivalList = ArrayList<Arrival>()

            arrivalList.add(Arrival("Hyde Park","N41015 ", "LOUIS VUITTON",9999999.0, R.drawable.bag, R.drawable.star_ic,"211000KS",4.0))
            arrivalList.add(Arrival("HORNS PINK LONG","SLEEVE T SHIRT","Lady Gaga", 72000.0, R.drawable.tshirt, R.drawable.ic_fillstar,"",5.0))
            arrivalList.add(Arrival("IPhone 11 Pro Max","","Apple", 2500000.0, R.drawable.iphone11, R.drawable.star_ic, "",6.0))

            var arrivalAdapter = ArrivalAdapter(arrivalList, this)

            arrivalRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

            arrivalRecyclerView.adapter = arrivalAdapter

    }


    fun chooseCountry(){
        var countryRecyclerView: RecyclerView = findViewById(R.id.recycler_country)

        var countryList = ArrayList<Country>()

        countryList.add(Country("Japan", R.drawable.japanone))
        countryList.add(Country("Korea", R.drawable.korea1))
        countryList.add(Country("China", R.drawable.china))
        countryList.add(Country("International", R.drawable.worldtrade))

        var countryAdapter = CountryAdapter(countryList)

        countryRecyclerView.layoutManager = GridLayoutManager(this,2)

        countryRecyclerView.adapter = countryAdapter
    }


    fun popularProduct(){
        var productRecyclerView: RecyclerView = findViewById(R.id.recycler_popular)

        var popularList = ArrayList<Product>()

        popularList.add(Product("NEW","30% off", "Iphone 11 pro max", "Apple", 980000.0, R.drawable.iphone11promax,"110000KS", 5.0))
        popularList.add(Product("NEW","34% off", "GhostedBed 11 inch Cooling Gel Memory Foam......", "GhostBed", 359000.0, R.drawable.bed, "49600KS", 5.0))
        popularList.add(Product("0", "0", "Nintendo Switch-Neon Blue and Red Joy-Con", "Nintendo", 359000.0, R.drawable.nintendotwo, "", 4.0))
        popularList.add(Product("NEW", "0","BELAROI Womens Comfy Swing Tunic Short.....", "Belaroi", 18990.0, R.drawable.swingtunic, "", 4.0))

        var popularAdapter = PopularAdapter(popularList )

        productRecyclerView.layoutManager = LinearLayoutManager(this)

        productRecyclerView.adapter = popularAdapter
    }
}
