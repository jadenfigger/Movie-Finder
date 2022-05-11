package com.example.similarmoviefinder.ui.home.adapter

import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.similarmoviefinder.databinding.GridViewItemBinding
import com.example.similarmoviefinder.network.Movie

class MovieViewHolder(
    private val binding: GridViewItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        binding.movie = movie
    }
}