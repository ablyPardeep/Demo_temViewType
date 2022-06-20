package com.demoitemviewtype.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.demoitemviewtype.R
import com.demoitemviewtype.model.Banner


class BannerAdapter(private var context: Context, private var bannersItems: ArrayList<*>) : PagerAdapter() {

    private var mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int {
        return bannersItems.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView: View = mLayoutInflater.inflate(R.layout.banner, container, false)
        val imageView = itemView.findViewById(R.id.bannerImage) as ImageView
        val data = bannersItems[position] as Banner
        Glide.with(context).load(data.image).placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background).into(imageView)
        container.addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }

}