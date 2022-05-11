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

import android.R
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.example.similarmoviefinder.databinding.GridViewItemBinding
import com.example.similarmoviefinder.network.Movie
import com.example.similarmoviefinder.ui.home.HomeFragment
import com.squareup.picasso.Picasso


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
        Log.i("status", movie.title+" "+movie.poster_path)
        val imageUri = "https://image.tmdb.org/t/p/w300_and_h450_bestv2${movie.poster_path}"
        Picasso.get().load(imageUri).into(binding.posterImg)

        holder.itemView.setOnClickListener {
            navigateToWithinMovie
        }

        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

}

