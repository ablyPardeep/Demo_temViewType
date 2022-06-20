package com.demoitemviewtype.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.demoitemviewtype.R
import com.demoitemviewtype.model.DataViewItem
import com.demoitemviewtype.model.VerticalList
import me.relex.circleindicator.CircleIndicator


class MainAdapter(private val context: Context, private val items: ArrayList<DataViewItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val vertical = 1
    private val horizontal = 2
    private val banner = 3
    //this method returns the number according to the Vertical/Horizontal object
    override fun getItemViewType(position: Int): Int {
       return items[position].type
    }

    //this method returns the holder that we've inflated according to the viewType.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View
        val holder: RecyclerView.ViewHolder
        when (viewType) {
            vertical -> {
                view = inflater.inflate(R.layout.vertical, parent, false)
                holder = VerticalViewHolder(view)
            }
            horizontal -> {
                view = inflater.inflate(R.layout.horizontal, parent, false)
                holder = HorizontalViewHolder(view)
            }
            banner -> {
                view = inflater.inflate(R.layout.items_banner, parent, false)
                holder = BannerViewHolder(view)
            }
            else -> {
                view = inflater.inflate(R.layout.horizontal, parent, false)
                holder = HorizontalViewHolder(view)
            }
        }
        return holder
    }

    //here we bind view with data according to the position that we have defined.
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            vertical -> verticalView(position,holder as VerticalViewHolder)
            horizontal -> horizontalView(position,holder as HorizontalViewHolder)
            banner -> bannerView(position,holder as BannerViewHolder)
        }
    }

    private fun verticalView(position: Int,holder: VerticalViewHolder) {
        val adapter1 = VerticalAdapter(items[position].list.filterIsInstance<VerticalList>())
        holder.recyclerView.layoutManager = LinearLayoutManager(context)
        holder.recyclerView.adapter = adapter1
    }


    private fun horizontalView(position: Int, holder: HorizontalViewHolder) {
        val adapter = HorizontalAdapter(items[position].list)
        holder.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        holder.recyclerView.adapter = adapter
    }


    private fun bannerView(position: Int,holder: BannerViewHolder){
        val adapter = BannerAdapter(context,items[position].list)
        holder.bannerVp.adapter = adapter
        holder.indicator.setViewPager(holder.bannerVp)
    }
    override fun getItemCount(): Int {
        return items.size
    }

    inner class HorizontalViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var recyclerView: RecyclerView

        init {
            recyclerView = itemView.findViewById<View>(R.id.inner_recyclerView) as RecyclerView
        }
    }

    inner class VerticalViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var recyclerView: RecyclerView

        init {
            recyclerView = itemView.findViewById<View>(R.id.inner_recyclerView) as RecyclerView
        }
    }

    inner class BannerViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var bannerVp: ViewPager
        var indicator : CircleIndicator

        init {
            bannerVp = itemView.findViewById<View>(R.id.bannervp) as ViewPager
            indicator = itemView.findViewById(R.id.pageIndicatorView) as CircleIndicator
        }
    }
}