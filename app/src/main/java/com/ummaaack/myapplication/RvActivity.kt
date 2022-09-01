package com.ummaaack.myapplication

import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import android.view.ViewTreeObserver.OnGlobalFocusChangeListener
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RvActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv)
      //  val fcv1 = findViewById<Fra>(R.id.fcv1)
     //   val fcv2 = findViewById<RecyclerView>(R.id.fcv2)

        //  rv1.recycledViewPool.setMaxRecycledViews(0, 1000)
        val propPool = RecyclerView.RecycledViewPool()
        //  Log.e("-", "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ" + rv.recycledViewPool.getRecycledView(0))

    }
}