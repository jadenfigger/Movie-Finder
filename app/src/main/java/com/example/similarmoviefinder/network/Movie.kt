package com.example.similarmoviefinder.network

data class Movie(
    val id: Int,
    val title: String,
    val popularity: Double,
    val release_date: String,
    val poster_path: String
)
