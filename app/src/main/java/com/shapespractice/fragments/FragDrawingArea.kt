package com.shapespractice.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shapespractice.R

class FragDrawingArea: Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        /* The layout to use for this fragment */
        return inflater.inflate(R.layout.activity_frag_drawing_area, container, false)
    }
}