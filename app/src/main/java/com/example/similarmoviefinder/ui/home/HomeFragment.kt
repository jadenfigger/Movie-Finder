package com.example.similarmoviefinder.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.SearchView
import android.widget.Toast
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

        movieAdapter = MovieAdapter(MovieAdapter.OnClickListener { movie ->
            Toast.makeText(activity, movie.title, Toast.LENGTH_SHORT).show()
        })


        viewModel.status.observe(viewLifecycleOwner, Observer {
            if (it == MovieApiStatus.None) {
                binding.noMovies.visibility = View.VISIBLE
            } else {
                binding.noMovies.visibility = View.INVISIBLE
            }
        })

        viewModel.listResult.observe(viewLifecycleOwner, Observer {
            val list = it.results
            movieAdapter.
        })

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null && query != "") {
                    viewModel.getMarsPhotos(query)
                    val emptyList: List<Movie> = emptyList()
                    binding.moviesList.adapter = MovieAdapter(emptyList)
                    Log.i("status", query)
                }
                binding.searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }

        })
        return binding.root
    }



}