package com.example.foodmenuintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private var myFoodMenu = DataSource().loadFoodMenu()

    private var isGridLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvFoodMenu)
        chooseLayout()

    }

    private fun chooseLayout() {

        if ( isGridLayoutManager ) {
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        }
        else {
            recyclerView.layoutManager = StaggeredGridLayoutManager(3, 1)
        }
        recyclerView.adapter = ItemAdapter(this, myFoodMenu)

    }

    private fun setIcon( menuItem: MenuItem? ) {
        if ( menuItem == null ) return

        menuItem.icon =

            if ( isGridLayoutManager ) {
                ContextCompat.getDrawable(this, R.drawable.ic_view_list)
            }else{
                ContextCompat.getDrawable(this, R.drawable.ic_grid_view)
            }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu?.findItem(R.id.switch_action)
        setIcon(layoutButton)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when ( item.itemId ) {
            R.id.switch_action -> {
                isGridLayoutManager = !isGridLayoutManager

                chooseLayout()
                setIcon(item)

                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}