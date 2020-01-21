package com.hnineiphyu.onlineshop.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.hnineiphyu.onlineshop.R

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val firstName  = intent.getStringExtra("ARRIVAL_FIRST_NAME")

        val nameone = findViewById<TextView>(R.id.name_one_arrival).apply {
            text = firstName
        }

        val  secondName = intent.getStringExtra("ARRIVAL_SECOND_NAME")

        val nametwo = findViewById<TextView>(R.id.name_two_arrival).apply {
            text = secondName
        }

        val arrivalBrand  = intent.getStringExtra("ARRIVAL_BRAND")

        val brand = findViewById<TextView>(R.id.quality_arrival).apply {
            text = arrivalBrand
        }

        val arrivalPrice  = intent.getStringExtra("ARRIVAL_PRICE")

        val price = findViewById<TextView>(R.id.quality_arrival).apply {
            text = arrivalPrice
        }

        val arrivalImage = intent.getIntExtra("ARRIVAL_IMAGE", R.drawable.bag)

        val image = findViewById<ImageView>(R.id.image_arrival).apply {
            setImageResource(arrivalImage)
        }
    }
}
