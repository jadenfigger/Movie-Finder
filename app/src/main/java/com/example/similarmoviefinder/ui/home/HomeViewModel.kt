package com.example.similarmoviefinder.ui.home

import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.similarmoviefinder.network.MovieApi
import kotlinx.coroutines.launch

enum class MovieApiStatus { LOADING, ERROR, DONE }


class HomeViewModel : ViewModel() {

    val api_key: String = "ba2a3532353775410cbf957b93e2040d"

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */
    private fun getMarsPhotos() {
        viewModelScope.launch {
            try {
                val listResult = MovieApi.retrofitService.getMovies(api_key, "batman", 1)
                _status.value = "Success: ${listResult.size} Mars photos retrieved"
                d("status", "Success: ${listResult.size} Mars photos retrieved")
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
                d("status", "Failure: ${e.message}")
            }
        }
    }
}