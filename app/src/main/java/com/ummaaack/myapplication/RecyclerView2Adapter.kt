package com.ummaaack.myapplication

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ummaaack.myapplication.databinding.Item2Binding
import com.ummaaack.myapplication.databinding.ItemBinding
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class RecyclerView2Adapter @Inject constructor(
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    init{
        Log.e("+-+", "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ어댑터 생성ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ")
    }
    var count = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        count += 1
        Log.e("+-+", "------onCreateViewHolder - type: $viewType count - : $count")
        //    return if (viewType == ITEM) {
        //  return ItemViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        //   } else {
        return Item2ViewHolder(Item2Binding.inflate(LayoutInflater.from(parent.context), parent, false))
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
        return 15
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
            Log.e("+-+", "Item2ViewHolder: $adapterPosition")
            binding.tv.text = "${adapterPosition}번째 홀더입니다"
        }
    }

    companion object {
        private const val ITEM = 1
        private const val ITEM2 = 2
    }
}