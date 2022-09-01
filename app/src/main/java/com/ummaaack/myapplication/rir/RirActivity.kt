package com.ummaaack.myapplication.rir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ummaaack.myapplication.R


class RirActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rir)
        val fcv1 = findViewById<RecyclerView>(R.id.rv)
        fcv1.adapter = RvAdapter(this)
        fcv1.layoutManager = LinearLayoutManager(this)
    }
}