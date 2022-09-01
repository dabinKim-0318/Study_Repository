package com.ummaaack.myapplication.rir

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ummaaack.myapplication.databinding.Item2Binding
import com.ummaaack.myapplication.databinding.ItemBinding
import com.ummaaack.myapplication.databinding.RirBinding
import com.ummaaack.myapplication.pool.RecyclerView2Adapter


class RvAdapter constructor(
    val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var count = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        count += 1
        Log.e("+-.+", "------onCreateViewHolder - type: $viewType count - : $count")
        return if (viewType == ITEM1) {
            val view = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return Item1ViewHolder(view)
        } else {
            val view = RirBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return Item2ViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val type = getItemViewType(position)
        if (type == ITEM1) {
            (holder as Item1ViewHolder)
        } else
            (holder as Item2ViewHolder)
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun getItemViewType(position: Int): Int {
        return if (position%2==0)
            ITEM1
        else
            ITEM2

    }


    inner class Item1ViewHolder(var binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
        }
    }

    //재사용할 홀더 가져오기
    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
        Log.e("+-.+vv", "onViewRecycledㅡㅡㅡㅡㅡ: ${holder.adapterPosition}")
    }


    inner class Item2ViewHolder(var binding: RirBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.rv.adapter = RecyclerView2Adapter(binding.rv)
            val gridLayoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            binding.rv.layoutManager = gridLayoutManager
        }
    }

    companion object {
        private const val ITEM1 = 1
        private const val ITEM2 = 2
        private const val ITEM3 = 3
    }
}