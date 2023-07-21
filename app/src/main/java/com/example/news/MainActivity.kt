package com.example.news

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bg=findViewById<ConstraintLayout>(R.id.wowie)
        val recyclerview = findViewById<RecyclerView>(R.id.recycle)

        val retrofitBuilder=Retrofit.Builder().baseUrl("https://newsapi.org/").addConverterFactory(GsonConverterFactory.create()).build().create(Inter::class.java)
        val retrofitData=retrofitBuilder.getdata()
        var x=1

        retrofitData.enqueue(object : Callback<newsdata?> {
            override fun onResponse(call: Call<newsdata?>, response: Response<newsdata?>) {
                val rep =response.body()
                val list=rep!!.articles
                val adapter=Adapter(list)
                recyclerview.adapter=adapter
                recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)

            }

            override fun onFailure(call: Call<newsdata?>, t: Throwable) {
                Log.d("Main","Fail"+t.message)
            }
        })
    }
}