package com.demoitemviewtype.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demoitemviewtype.R
import com.demoitemviewtype.model.VerticalList
import de.hdodenhof.circleimageview.CircleImageView


class VerticalAdapter(data: List<VerticalList>) : RecyclerView.Adapter<VerticalAdapter.MyViewHolder>() {
    private var data: List<VerticalList> = ArrayList()
    private lateinit var ctx : Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        ctx = parent.context
        val view= LayoutInflater.from(parent.context).inflate(R.layout.items_vertical, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.image.setImageResource(data[position].image)

        Glide.with(ctx).load(data[position].image).placeholder(R.mipmap.ic_launcher_round)
            .error(R.mipmap.ic_launcher_round).into(holder.image)
        holder.title.text = data[position].name

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var title: TextView

        init {
            image = itemView.findViewById(R.id.image) as CircleImageView
            title = itemView.findViewById(R.id.textName)

        }
    }

    init {
        this.data = data
    }
}