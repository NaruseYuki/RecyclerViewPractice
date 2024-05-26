package com.yushin.recyclerviewpractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yushin.recyclerviewpractice.R
import com.yushin.recyclerviewpractice.fragment.OnClickItemPresenter
import com.yushin.recyclerviewpractice.model.ItemModel

class MainViewAdapter(
    private val list: List<ItemModel>,
    private val presenter: OnClickItemPresenter
) : RecyclerView.Adapter<MainViewAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.part_item, parent, false)
        return MainViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.item_model).text = list[position].text
        holder.itemView.setOnClickListener {
            presenter.onClickItem(it, list[position])
        }
    }

    override fun getItemCount(): Int = list.size

    class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.item_model)
    }
}