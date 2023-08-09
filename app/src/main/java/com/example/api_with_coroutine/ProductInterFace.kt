package com.example.api_with_coroutine

import retrofit2.http.GET
import retrofit2.http.Path

interface ProductInterFace {
        @GET("products/{id}")
        fun getProduct(@Path("id") id: Int):retrofit2.Call<Product>
    }