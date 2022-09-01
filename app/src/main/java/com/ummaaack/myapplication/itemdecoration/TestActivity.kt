package com.ummaaack.myapplication.itemdecoration

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ummaaack.myapplication.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TestActivity : AppCompatActivity() {
    private lateinit var adapter: StickyHeaderAdapter

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)


    }
}