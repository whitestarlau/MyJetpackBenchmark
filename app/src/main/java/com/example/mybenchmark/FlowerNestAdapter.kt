package com.example.mybenchmark

import android.widget.ImageView
import com.chad.library.adapter.base.BaseBinderAdapter
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.mybenchmark.databinding.ItemFlowerLayoutBinding
import com.example.mybenchmark.databinding.ItemFlowerLayoutNestBinding

class FlowerNestAdapter :
    BaseQuickAdapter<FlowerItem, BaseDataBindingHolder<ItemFlowerLayoutNestBinding>>
        (R.layout.item_flower_layout_nest) {

    override fun convert(
        holder: BaseDataBindingHolder<ItemFlowerLayoutNestBinding>,
        item: FlowerItem
    ) {
        holder.dataBinding?.flowerItem = item
    }

}