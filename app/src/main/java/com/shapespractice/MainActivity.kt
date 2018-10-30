package com.shapespractice

import android.graphics.Paint
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Gravity
import android.view.MenuItem

class MainActivity : AppCompatActivity()
{
    private lateinit var drawerLayout:DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val paint = Paint()
        val drawingArea = DrawingArea(this, paint)
//        setContentView(drawingArea)
//        setContentView(R.layout.drawer_menu_header_layout)
        setContentView(R.layout.activity_main)

        val toolBar: Toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolBar)

        val actionBar: ActionBar? = supportActionBar

        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        drawerLayout = findViewById(R.id.drawerLayout)

        val navigationView: NavigationView = findViewById(R.id.navView)

        navigationView.setNavigationItemSelectedListener { aMenuItem ->
            // Set the tapped menu item as checked so that it can be highlighted
            aMenuItem.isChecked = true

            // Close the drawer after the tap
            drawerLayout.closeDrawers()

            // The when expression replaces the switch statement
            when(aMenuItem.title)
            {
                //TODO add a fragment containing the drawing for the selected menu item

                getString(R.string.txt_bar_chart) ->
                    Log.i("MenuTap", getString(R.string.txt_bar_chart))

                getString(R.string.txt_clock)     ->
                    Log.i("MenuTap", getString(R.string.txt_clock))

                else -> print("Unknown menu item was tapped")
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean
    {
        /* Link https://developer.android.com/guide/topics/ui/menus.html#RespondingOptionsMenu
           When you successfully handle a menu item, return true.
           If you don't handle the menu item, you should call the
           superclass implementation of onOptionsItemSelected()
           (the default implementation returns false).*/
        return when (item?.itemId)
        {
            // Id's prefixed with "android" are native to Android
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }


    }

}
