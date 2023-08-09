package com.example.api_with_coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_with_coroutine.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        Toast.makeText(this,"${intent.getStringArrayListExtra("ProductImage")!!},",Toast.LENGTH_LONG).show()
        binding.imgeRecycle.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.imgeRecycle.adapter=ImageListAdapter(intent.getStringArrayListExtra("ProductImage")!!)
    }
}