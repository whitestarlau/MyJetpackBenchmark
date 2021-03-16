package com.example.mybenchmark

import android.widget.ImageView
import com.chad.library.adapter.base.BaseBinderAdapter
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.mybenchmark.databinding.ItemFlowerLayoutBinding

class FlowerAdapter :
    BaseQuickAdapter<FlowerItem, BaseDataBindingHolder<ItemFlowerLayoutBinding>>(R.layout.item_flower_layout) {

    override fun convert(holder: BaseDataBindingHolder<ItemFlowerLayoutBinding>, item: FlowerItem) {
        holder.dataBinding?.flowerItem = item
    }

}