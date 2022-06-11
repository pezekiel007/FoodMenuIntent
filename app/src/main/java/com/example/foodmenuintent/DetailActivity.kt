package com.example.foodmenuintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val foodDetail = findViewById<TextView>(R.id.foodDetail)
        val priceDetail = findViewById<TextView>(R.id.priceDetail)
        val imageDetail = findViewById<ImageView>(R.id.imageDetail)
        val descriptionDetail = findViewById<TextView>(R.id.descriptionDetail)

        val bundle : Bundle? = intent.extras

        val name = bundle!!.getInt("food")
        val price = bundle.getInt("price")
        val image = bundle.getInt("image")
        val details = bundle.getInt("details")

        foodDetail.setText(name)
        priceDetail.setText(price)
        imageDetail.setImageResource(image)
        descriptionDetail.setText(details)

    }
}