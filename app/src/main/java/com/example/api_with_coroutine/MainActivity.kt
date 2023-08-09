package com.example.api_with_coroutine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.api_with_coroutine.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.internal.wait
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.FieldPosition

class MainActivity : AppCompatActivity(), ProductAdapter.ONItemClick {
    lateinit var binding: ActivityMainBinding
    lateinit var productList: MutableList<Product>

    //    lateinit var retrofit:Retrofit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        productList = mutableListOf()
        CoroutineScope(Dispatchers.IO).launch {
              for(i in 1..30) {
                var call = ApiInstance.apiService.getProduct(i)

                call.enqueue(object : Callback<Product> {
                    override fun onResponse(call: Call<Product>, response: Response<Product>) {
                       // Toast.makeText(this@MainActivity,"success${response.body()!!.brand}",Toast.LENGTH_LONG).show()
                        productList.add(response.body()!!)
                    }

                    override fun onFailure(call: Call<Product>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "bad", Toast.LENGTH_LONG).show()

                    }

                })
           launch(Dispatchers.Main) {
               delay(2000)
               binding.prducRecycle.adapter = ProductAdapter(productList, this@MainActivity)
           }


        } }



    }

    override fun onItemClick(position: Int) {
            var intent= Intent(this,MainActivity2::class.java)
        intent.putStringArrayListExtra("ProductImage",productList[position].images)
        startActivity(intent)
    }
}