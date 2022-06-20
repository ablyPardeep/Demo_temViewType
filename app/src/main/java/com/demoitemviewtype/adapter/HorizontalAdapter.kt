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
import com.demoitemviewtype.model.DataViewItem
import com.demoitemviewtype.model.HorizontalList
import com.demoitemviewtype.model.VerticalList
import de.hdodenhof.circleimageview.CircleImageView

class HorizontalAdapter(private var data: ArrayList<*>) : RecyclerView.Adapter<HorizontalAdapter.MyViewHolder>() {
    private lateinit var ctx : Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        ctx = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_horizontal, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

           val data1 = data[position] as HorizontalList

           holder.title.text = data1.name

           Glide.with(ctx).load(data1.image).placeholder(R.mipmap.ic_launcher_round)
               .error(R.mipmap.ic_launcher_round).into(holder.image)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var image: ImageView

        init {
            title = itemView.findViewById(R.id.textName)
            image = itemView.findViewById(R.id.image)
        }
    }

}