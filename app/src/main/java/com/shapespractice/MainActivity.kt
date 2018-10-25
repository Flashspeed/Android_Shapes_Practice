package com.shapespractice

import android.annotation.SuppressLint
import android.graphics.Paint
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.WindowManager

class MainActivity : AppCompatActivity()
{

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val paint = Paint()
        val drawingArea = DrawingArea(this, paint)
//        setContentView(drawingArea)
        setContentView(R.layout.activity_main)

//        var toolbar: android.support.v7.widget.Toolbar = findViewById(R.id.toolBar)
        val actionBarUtil = supportActionBar

        Log.i("ActionBar", (actionBarUtil?.height).toString())
//        setSupportActionBar(toolbar)
    }
}
