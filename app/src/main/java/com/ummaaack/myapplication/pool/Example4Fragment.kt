package com.ummaaack.myapplication.pool

import android.R
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ummaaack.myapplication.BaseViewUtil
import com.ummaaack.myapplication.databinding.FragmentExample2Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class Example4Fragment : BaseViewUtil.BaseFragment<FragmentExample2Binding>(com.ummaaack.myapplication.R.layout.fragment_example2) {
    //  lateinit var recyclerView2Adapter: RecyclerView2Adapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("-", "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡExample4Fragmentㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ")

        binding.rv.adapter = RecyclerView2Adapter(binding.rv) //어댑터 설정
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.setRecycledViewPool(Share.sharedPool)
        binding.rv.setItemViewCacheSize(3)
        (binding.rv.layoutManager as LinearLayoutManager).recycleChildrenOnDetach = true //
    }
}