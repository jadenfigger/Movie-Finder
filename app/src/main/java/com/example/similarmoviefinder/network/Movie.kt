package com.example.similarmoviefinder.network

import com.squareup.moshi.Json

// The data classes for the movies
data class MoviePage(
    @Json(name="page")
    val page: Int,
    @Json(name="results")
    val results: List<Movie>,
    @Json(name="total_pages")
    val total_pages: Int
) {
    fun getSize(): Int {return results.size}
}

data class Movie(
    val id: Int,
    val title: String,
    val popularity: Double,
    val release_date: String,
    val poster_path: String
) {
}
