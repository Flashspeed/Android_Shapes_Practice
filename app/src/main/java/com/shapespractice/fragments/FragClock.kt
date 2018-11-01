package com.shapespractice.fragments

import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shapespractice.DrawingArea
import com.shapespractice.R

class FragClock: Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        /* Remove all the child views that are currently in the fragment container.
           Because I am using the canvas, if I don't do this the other views can be
           shown over this fragment (Overlap).
         */
        for (index in 1 until container?.childCount!!)
        {
            container.removeViewAt(index)
        }
        // Now I can add the view I want
//        container.addView(DrawingManager(ctx=context!!))
        container.addView(object:View(context){
            private val paint = Paint()
            private val drawingArea: DrawingArea = DrawingArea(context, paint)
            override fun onDraw(canvas: Canvas?)
            {
                super.onDraw(canvas)
                drawingArea.drawClock(canvas)
            }
        })

        /* The layout to use for this fragment */
        return inflater.inflate(R.layout.activity_frag_drawing_area, container, false)
    }
}