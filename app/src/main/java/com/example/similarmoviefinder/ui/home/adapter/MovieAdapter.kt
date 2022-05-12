/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.similarmoviefinder.ui.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.similarmoviefinder.databinding.GridViewItemBinding
import com.example.similarmoviefinder.network.Movie
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.squareup.picasso.Picasso
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL
import java.net.URLConnection


class MovieAdapter(
    private val moviesList: List<Movie>
) : RecyclerView.Adapter<MovieViewHolder>() {

private lateinit var binding: GridViewItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        binding = GridViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = moviesList[position]
//        Log.i("status", movie.title+" "+movie.poster_path)
//        val imageUri = "https://image.tmdb.org/t/p/w300_and_h450_bestv2${movie.poster_path}"

        // Setting the text in the recyclerview with the movietitle
        binding.textView3.text = movie.title

        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

}

