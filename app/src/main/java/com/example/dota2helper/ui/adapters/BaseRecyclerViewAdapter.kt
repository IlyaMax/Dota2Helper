package com.example.dota2helper.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView


abstract class BaseRecyclerViewAdapter<T, VH : BaseViewHolder<T>>(context: Context) :
    RecyclerView.Adapter<VH>() {

    private val items: MutableList<T> = ArrayList<T>()
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    val isEmpty get() = itemCount == 0

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.onBind(item)
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: List<T>?) {
        this.items.clear()
        this.items.addAll(items!!)
        notifyDataSetChanged()
    }

    fun getItems(): List<T>? = items

    fun add(item: T?) {
        items.add(item!!)
        notifyItemInserted(items.size - 1)
    }

    fun addAll(items: List<T>?) {
        this.items.addAll(items!!)
        notifyItemRangeInserted(this.items.size - items.size, items.size)
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    fun remove(item: T) {
        val position = items.indexOf(item)
        if (position > -1) {
            items.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    protected fun inflate(@LayoutRes layout: Int, parent: ViewGroup?, attachToRoot: Boolean = false): View {
        return layoutInflater.inflate(layout, parent, attachToRoot)
    }
}