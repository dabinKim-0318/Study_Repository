package com.ummaaack.myapplication.pool

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ummaaack.myapplication.BaseViewUtil
import com.ummaaack.myapplication.databinding.FragmentExample2Binding
import com.ummaaack.myapplication.databinding.FragmentExample3Binding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class Example5Fragment : BaseViewUtil.BaseFragment<FragmentExample3Binding>(com.ummaaack.myapplication.R.layout.fragment_example3) {

    // lateinit var recyclerView2Adapter: RecyclerView2Adapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("-", "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡExample4Fragmentㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ")
        binding.rv.adapter = RecyclerView2Adapter(binding.rv) //어댑터 설정
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        val activity = requireActivity() as PoolRvActivity
        binding.rv.setRecycledViewPool(Share.sharedPool)
       binding.rv.setItemViewCacheSize(3)
        (binding.rv.layoutManager as LinearLayoutManager).recycleChildrenOnDetach = true
    }
}