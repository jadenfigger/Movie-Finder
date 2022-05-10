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

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.similarmoviefinder.databinding.GridViewItemBinding
import com.example.similarmoviefinder.network.Movie

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
    holder.bind(movie)
}

override fun getItemCount(): Int = moviesList.size

}

