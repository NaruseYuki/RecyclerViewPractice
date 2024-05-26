package com.yushin.recyclerviewpractice.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yushin.recyclerviewpractice.R
import com.yushin.recyclerviewpractice.adapter.MainViewAdapter
import com.yushin.recyclerviewpractice.model.ItemModel

class MainFragment : Fragment(), OnClickItemPresenter {
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.recyclerView = view.findViewById(R.id.container_recycler_view)

        this.recyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
            adapter = MainViewAdapter(
                generateItemList(), this@MainFragment
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this.recyclerView?.adapter = null
        this.recyclerView = null
    }

    //RecyclerViewの生成時に一度だけ動く
    private fun generateItemList(): List<ItemModel> {
        val itemList = mutableListOf<ItemModel>()
        for (i in 0..100) {
            val item: ItemModel = ItemModel().apply {
                text = "List${i}個目だよ"
            }
            itemList.add(item)
        }
        return itemList
    }

    override fun onClickItem(tappedView: View, itemModel: ItemModel) {
        val context: Context = tappedView.context
        Toast.makeText(context, itemModel.text, Toast.LENGTH_SHORT).show()
    }
}

//RecyclerView内のアイテムがクリックされたときに動く
interface OnClickItemPresenter {
    fun onClickItem(tappedView: View, itemModel: ItemModel)
}