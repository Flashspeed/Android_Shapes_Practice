package com.shapespractice.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shapespractice.R

class FragSayHello: Fragment()
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

        /* Container is the fragment container definined in the root view which in my case
           is in activity_main.xml */
        return inflater.inflate(R.layout.activity_frag_say_hello, container, false)
    }
}