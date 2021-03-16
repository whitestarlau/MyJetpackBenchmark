package com.example.mybenchmark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mybenchmark.databinding.ActivityMainBinding
import com.example.mybenchmark.databinding.ItemFlowerLayoutBinding

class MainActivity : AppCompatActivity() {
    companion object {
        private fun buildFlowerItem(): FlowerItem {
            return FlowerItem(
                "bougainvillea",
                "叶子花，九重葛(热带攀缘植物，开红、紫、白或粉色花);",
                "https://upload.wikimedia.org/wikipedia/commons/6/6d/Paperflower_--_Bougainvillea_glabra.jpg"
            )
        }
    }

    val mBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
    }

    fun initData() {
        val datas = ArrayList<FlowerItem>()
        repeat(10){
            datas.add(buildFlowerItem())
        }

        val adapter = FlowerNestAdapter()
        adapter.setNewInstance(datas)

        val rv = mBinding.contentRv
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
    }
}