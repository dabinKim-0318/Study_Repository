package com.ummaaack.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.ummaaack.myapplication.pool.Example2Fragment

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

       supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
           // .attach(R.id.example_fragment_container_view, ExampleFragment(), "ExampleFragment")
            .commit()
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.example_fragment_container_view, Example2Fragment(), "Example2Fragment")
            .commit()
        // 텍스트 뷰 클릭시 작업
        val attach = findViewById<TextView>(R.id.show)
        attach.setOnClickListener {
            val exampleFragment = supportFragmentManager.findFragmentByTag("Example2Fragment")
            if(exampleFragment!=null)
            supportFragmentManager.beginTransaction()
                .show(exampleFragment!!)
                .commit()
        }
        val detach = findViewById<TextView>(R.id.hide)
        detach.setOnClickListener {
            val exampleFragment = supportFragmentManager.findFragmentByTag("Example2Fragment")
            if(exampleFragment!=null)
            supportFragmentManager.beginTransaction()
                .hide(exampleFragment!!)
                .commit()
        }
        Log.d("ㅡㅡㅡㅡㅡㅡㅡBㅡㅡㅡㅡㅡㅡㅡ", "onCreate")
    }
    override fun onStart() {
        super.onStart()
        Log.d("ㅡㅡㅡㅡㅡㅡㅡBㅡㅡㅡㅡㅡㅡㅡ", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ㅡㅡㅡㅡㅡㅡㅡBㅡㅡㅡㅡㅡㅡㅡ", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ㅡㅡㅡㅡㅡㅡㅡBㅡㅡㅡㅡㅡㅡㅡ", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ㅡㅡㅡㅡㅡㅡㅡBㅡㅡㅡㅡㅡㅡㅡ", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ㅡㅡㅡㅡㅡㅡㅡBㅡㅡㅡㅡㅡㅡㅡ", "onDestroy")
    }
}