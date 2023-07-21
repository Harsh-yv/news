package com.example.news

import retrofit2.Call
import retrofit2.http.GET

interface Inter {
    @GET("\n" +
            "/v2/everything?q=apple&from=2023-07-20&to=2023-07-20&sortBy=popularity&apiKey=e087a890dfef4b2c9903ba9e6db9e197")
    fun getdata():Call<newsdata>
}