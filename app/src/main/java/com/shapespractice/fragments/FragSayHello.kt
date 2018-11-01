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
        /* Container is the fragment container definined in the root view which in my case
           is in activity_main.xml */
        return inflater.inflate(R.layout.activity_frag_say_hello, container, false)
    }
}