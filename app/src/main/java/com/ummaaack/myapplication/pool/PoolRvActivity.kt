package com.ummaaack.myapplication.pool

import android.content.Intent
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
import com.ummaaack.myapplication.R
import dagger.hilt.android.AndroidEntryPoint

object Share{
    val sharedPool by lazy { RecyclerView.RecycledViewPool()  }
}
class PoolRvActivity : AppCompatActivity() {
   // val sharedPool = RecyclerView.RecycledViewPool() //pool생성
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv)
        //  val fcv1 = findViewById<Fra>(R.id.fcv1)
        //   val fcv2 = findViewById<RecyclerView>(R.id.fcv2)

        //  rv1.recycledViewPool.setMaxRecycledViews(0, 1000)
        val sharedPool = RecyclerView.RecycledViewPool()
        //  Log.e("-", "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ" + rv.recycledViewPool.getRecycledView(0))
        go()
    }

/*    fun getPool(): RecyclerView.RecycledViewPool {
        sharedPool.setMaxRecycledViews(0, 20)
        return sharedPool
    }*/

    fun go() {
   //   startActivity(Intent(this, PoolRv2Activity::class.java))
    }
}