package com.example.similarmoviefinder.ui.home

import android.util.Log
import android.util.Log.i
import android.widget.Toast
import androidx.lifecycle.*
import com.example.similarmoviefinder.network.Movie
import com.example.similarmoviefinder.network.MovieApi
import com.example.similarmoviefinder.network.MoviePage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse


enum class MovieApiStatus { None, Some }


class HomeViewModel : ViewModel() {

    val api_key: String = "ba2a3532353775410cbf957b93e2040d"

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<MovieApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<MovieApiStatus> = _status

    private val _listResult = MutableLiveData<MoviePage>()
    val listResult: LiveData<MoviePage> = _listResult
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */
    fun getMarsPhotos(query: String) {
        val result: Call<MoviePage> = MovieApi.retrofitService.getMovies(api_key, query, 1)
        result.enqueue(object: Callback<MoviePage> {
            override fun onResponse(
                call: Call<MoviePage>,
                response: Response<MoviePage>
            ) {
                _status.value = MovieApiStatus.Some
                _listResult.value = response.body()
            }

            override fun onFailure(call: Call<MoviePage>, t: Throwable) {
                i("status", "failure ${t.message}")
                _status.value = MovieApiStatus.None
            }
        })
    }
}