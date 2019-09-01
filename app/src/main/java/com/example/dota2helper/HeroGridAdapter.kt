package com.example.dota2helper

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import androidx.core.view.updateLayoutParams

class HeroGridAdapter(val context: Context?) : BaseAdapter() {
    var imageURLs:Array<String> = arrayOf()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView:ImageView
        if (convertView == null){
            imageView = ImageView(context)
            imageView.layoutParams = AbsListView.LayoutParams(185,185)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(5,5,5,5)
        }
        else{
            imageView = convertView as ImageView
        }
        //TODO: change using Picasso -> imageView.setImageResource(imageIDs[position])
        return imageView
    }

    override fun getItem(position: Int): Any {
        //TODO: maybe here also return imageIDs[position]
        return imageURLs[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return imageURLs.size
    }
}