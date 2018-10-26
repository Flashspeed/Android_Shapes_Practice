package com.shapespractice

import android.graphics.Paint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val paint = Paint()
        val drawingArea = DrawingArea(this, paint)
//        setContentView(drawingArea)
//        setContentView(R.layout.drawer_menu_header_layout)
        setContentView(R.layout.activity_main)
    }


}
