package com.example.news

data class newsdata(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)