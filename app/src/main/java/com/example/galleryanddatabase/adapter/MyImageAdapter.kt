package com.example.galleryanddatabase.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.galleryanddatabase.databinding.ItemRvBinding
import com.example.galleryanddatabase.models.MyImage

class MyImageAdapter( var list: ArrayList<MyImage>) : RecyclerView.Adapter<MyImageAdapter.Vh>() {
    inner class  Vh( var itemRv: ItemRvBinding):RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(myImage: MyImage) {
            itemRv.imageItem.setImageURI(Uri.parse(myImage.imageLink))
            itemRv.tvItem.text = myImage.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }


    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
}