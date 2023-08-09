package com.example.api_with_coroutine

import android.icu.text.CaseMap.Title

//data class RetrofitDataModel(var productList:List<Product>)
data class Product(
    var id:Int,
    var brand:String,
    var title:String,
    var description:String,
    var price:Double,
    var discountPercentage:Double,
    var thumbnail:String,
    var images:ArrayList<String>
)