package com.demoitemviewtype.model

 data class DataViewItem (
     var type :Int,
     var list : ArrayList<*>
     )

    data class Banner(
        val image: String
    )

   data class VerticalList(
        val name: String,
        val image: String
    )

   data class HorizontalList(
        val name: String,
        val image: String
    )

