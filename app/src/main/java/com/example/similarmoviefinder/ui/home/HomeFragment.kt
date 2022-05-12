// Jaden Figger
// Movie Searching
// 5/12/2022

package com.example.similarmoviefinder.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.similarmoviefinder.R
import com.example.similarmoviefinder.databinding.FragmentHomeBinding
import com.example.similarmoviefinder.network.Movie
import com.example.similarmoviefinder.ui.home.adapter.MovieAdapter

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false)


        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel


        // Setting no movies warning to visible/invisible based on movie status
        viewModel.status.observe(viewLifecycleOwner, Observer {
            if (it == MovieApiStatus.None) {
                binding.noMovies.visibility = View.VISIBLE
            } else {
                binding.noMovies.visibility = View.INVISIBLE
            }
        })

        // Observes the current movie from the movie adapter, and when the value changes, it updates the recyclerview
        viewModel.listResult.observe(viewLifecycleOwner, Observer {
            movieAdapter = MovieAdapter(it.results)
            binding.moviesList.adapter = movieAdapter
            Log.i("status", it.results[0].title)
        })

        // Called when the user searched on the search bar
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            @SuppressLint("NotifyDataSetChanged")
            // when the user submits
            override fun onQueryTextSubmit(query: String?): Boolean {
                // If the query isn't null or empty
                if (query != null && query != "") {
                    viewModel.getMarsPhotos(query)
                }
                // hides the keyboard
                binding.searchView.clearFocus()
                return true
            }

            // when the text changes
            override fun onQueryTextChange(p0: String?): Boolean {
                if (p0 == "") {
                    val emptyList: List<Movie> = emptyList()
                    binding.moviesList.adapter = MovieAdapter(emptyList)
                }
                return true
            }

        })
        return binding.root
    }



}