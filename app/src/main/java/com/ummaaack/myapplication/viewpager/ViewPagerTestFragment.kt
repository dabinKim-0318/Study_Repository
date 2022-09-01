package com.ummaaack.myapplication.viewpager

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ummaaack.myapplication.BaseViewUtil
import com.ummaaack.myapplication.R
import com.ummaaack.myapplication.databinding.FragmentViewPagerTestBinding
import com.ummaaack.myapplication.pool.Example2Fragment
import com.ummaaack.myapplication.pool.PoolRvActivity
import com.ummaaack.myapplication.pool.RecyclerView2Adapter
import com.ummaaack.myapplication.pool.Share


class ViewPagerTestFragment : BaseViewUtil.BaseFragment<FragmentViewPagerTestBinding>(com.ummaaack.myapplication.R.layout.fragment_view_pager_test) {
    private lateinit var adapter: ViewPagerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentList: List<Fragment>
        fragmentList = listOf(
            Example2Fragment(),
            Example2Fragment(),
            Example2Fragment(),
            Example2Fragment(),
            Example2Fragment(),
            Example2Fragment(),
        )
        adapter = ViewPagerAdapter(this)
        binding.vp.adapter = adapter
        adapter.fragments.addAll(fragmentList)
    }
}

class ViewPagerAdapter(f: Fragment) : FragmentStateAdapter(f) {

    val fragments = mutableListOf<Fragment>()
    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    override fun getItemCount(): Int {
        return fragments.size
    }


}