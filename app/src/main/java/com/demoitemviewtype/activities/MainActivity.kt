package com.demoitemviewtype.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demoitemviewtype.R
import com.demoitemviewtype.adapter.MainAdapter
import com.demoitemviewtype.model.*

/**
 * @author Pardeep Sharma
 * created on 20/06/2022
 */
class MainActivity : AppCompatActivity() {

    private val dataList: ArrayList<DataViewItem> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private val singleVerticals: ArrayList<VerticalList> = ArrayList()
    private val singleHorizontals: ArrayList<HorizontalList> = ArrayList()
    private val bannerList : ArrayList<Banner> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         recyclerView = findViewById(R.id.recyclerView)
        getVerticalData()
        getHorizontalData()
        getBannerData()
        list()
        val adapter = MainAdapter(this, dataList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun getVerticalData(): ArrayList<VerticalList> {

        singleVerticals.add(
            VerticalList(
                name = "jack",
                image = "https://picsum.photos/200/300?random=1"
            )
        )
        singleVerticals.add(
            VerticalList(
                name = "Sermon",
                image = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1005.jpg"
            )
        )
        singleVerticals.add(
            VerticalList(
                name = "willey",
                image = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1117.jpg"
            )
        )
        singleVerticals.add(
            VerticalList(
                name = "Gayle",
                image = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/867.jpg"
            )
        )
        return singleVerticals
    }


    private fun getHorizontalData(): ArrayList<HorizontalList> {

        singleHorizontals.add(HorizontalList(
            name = "Smith",
            image = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/545.jpg"
        ))
        singleHorizontals.add(HorizontalList(
            name = "Ricky",
            image = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1005.jpg"
        ))
        singleHorizontals.add(HorizontalList(
            name = "Symonds",
            image = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/1117.jpg"
        ))
        singleHorizontals.add(HorizontalList(
            name = "Martin",
            image = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/867.jpg"
        ))
        singleHorizontals.add(HorizontalList(
            name = "Symonds",
            image = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/369.jpg"
        ))
        singleHorizontals.add(HorizontalList(
            name = "Martin",
            image = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/775.jpg"
        ))
        singleHorizontals.add(HorizontalList(
            name = "Symonds",
            image = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/803.jpg"
        ))
        singleHorizontals.add(HorizontalList(
            name = "Martin",
            image = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/746.jpg"
        ))

        return singleHorizontals
    }

     private fun getBannerData() : ArrayList<Banner> {

        bannerList.add(Banner(
            image = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/892.jpg"
        ))
        bannerList.add(Banner(
            image = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/308.jpg"
        ))
        bannerList.add(Banner(
            image = "https://cloudflare-ipfs.com/ipfs/Qmd3W5DuhgHirLHGVixi6V76LhCkZUz6pnFt5AJBiyvHye/avatar/744.jpg"
        ))

        return bannerList
    }

    private fun list() {
        dataList.add(DataViewItem(1,singleVerticals))
        dataList.add(DataViewItem(2,singleHorizontals))
        dataList.add(DataViewItem(3,bannerList))
    }
}