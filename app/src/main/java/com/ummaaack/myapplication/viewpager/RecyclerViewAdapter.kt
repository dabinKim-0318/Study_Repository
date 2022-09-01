package com.ummaaack.myapplication.viewpager

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ummaaack.myapplication.databinding.FragmentExample2Binding
import com.ummaaack.myapplication.databinding.FragmentExample3Binding
import com.ummaaack.myapplication.databinding.Item2Binding
import com.ummaaack.myapplication.databinding.ItemBinding


class RecyclerViewAdapter constructor(
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var count = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        count += 1
        Log.e("+-+", "------onCreateViewHolder - type: $viewType count - : $count")
        //    return if (viewType == ITEM) {
        //  return ItemViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        //   } else {
        val view = Item2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        //   val innerRecyclerView = FragmentExample3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        //    val outerRecyclerView = FragmentExample2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        //   innerRecyclerView.rv.setRecycledViewPool(outerRecyclerView.rv.recycledViewPool)
        return Item2ViewHolder(view)
        //   }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //   val type = getItemViewType(position)
        //  if (getItemViewType(position) == ITEM)
        Log.e("+-+", "onBindViewHolder: ${position}")
        (holder as Item2ViewHolder).bind()
        //   else if (getItemViewType(position) == ITEM2) (holder as Item2ViewHolder).bind()
    }

    override fun getItemCount(): Int {
        return 25
    }

/*    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0)
            ITEM
        else ITEM2
    }*/


    //재사용할 홀더 가져오기
    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        super.onViewRecycled(holder)
        Log.e("+-+", "onViewRecycledㅡㅡㅡㅡㅡ: ${holder.adapterPosition}")
    }

    //rv->adapter에게 itemView가 잘 붙었다고 알림
    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        super.onViewAttachedToWindow(holder)
        Log.e("+-+", "onViewAttachedToWindow: ${holder.adapterPosition}")
    }

    //rv->adapter에게 itemView가 잘 떨어졌다고 알림
    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        Log.e("+-+", "onViewDetachedFromWindow: ${holder.adapterPosition}\"")
    }

    //rv 붙음
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        Log.e("+-+", "onAttachedToRecyclerView")
    }

    //rv 떨어짐
    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        Log.e("+-+", "onDetachedFromRecyclerView")
    }

    inner class ItemViewHolder(var binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            Log.e("+-+", "ItemViewHolder: $adapterPosition")
            binding.title.text = "${adapterPosition}번째 홀더입니다"
        }
    }

    inner class Item2ViewHolder(var binding: Item2Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.tv.text = "${adapterPosition}번째 홀더입니다"
        }
    }

    companion object {
        private const val ITEM = 1
        private const val ITEM2 = 2
    }
}