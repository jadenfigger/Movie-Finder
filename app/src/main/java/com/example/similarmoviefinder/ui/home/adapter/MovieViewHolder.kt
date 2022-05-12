package com.example.similarmoviefinder.ui.home.adapter

import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.similarmoviefinder.databinding.GridViewItemBinding
import com.example.similarmoviefinder.network.Movie
import com.example.similarmoviefinder.ui.home.HomeViewModel

class MovieViewHolder(
    private val binding: HomeViewModel
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        binding. = movie
    }
}