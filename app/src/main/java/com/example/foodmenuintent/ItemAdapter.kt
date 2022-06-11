package com.example.foodmenuintent

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter ( private val context: Context, private val foodMenu : List<DataClass> ) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder ( val view: View ) : RecyclerView.ViewHolder(view) {
        val foodName : TextView = view.findViewById(R.id.menuFood)
        val foodPrice : TextView = view.findViewById(R.id.menuPrice)
        val foodImage : ImageView = view.findViewById(R.id.menuImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = foodMenu[position]
        holder.foodName.text = context.resources.getString(item.foodResourceId)
        holder.foodPrice.text = context.resources.getString(item.priceResourceId)
        holder.foodImage.setImageResource(item.imageResourceId)

        holder.itemView.setOnClickListener {
            val context = holder.view.context
            val intent = Intent(context, DetailActivity::class.java)

            intent.putExtra("food",  item.foodResourceId)
            intent.putExtra("price", item.priceResourceId)
            intent.putExtra("image", item.imageResourceId)
            intent.putExtra("details", item.detailsResourceId)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return foodMenu.size
    }

}