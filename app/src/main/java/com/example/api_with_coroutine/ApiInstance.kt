package com.example.api_with_coroutine

import android.content.Context
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiInstance {
  var   retrofit= Retrofit.Builder().baseUrl("https://dummyjson.com/").addConverterFactory(
    GsonConverterFactory.create()).build()
    val apiService = retrofit.create(ProductInterFace::class.java)



}