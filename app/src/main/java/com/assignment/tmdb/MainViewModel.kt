package com.assignment.tmdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.tmdb.data.TopRatedResult
import com.assignment.tmdb.network.ApiClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val apiClient: ApiClient
) : ViewModel() {

    private val _topRatedMovies = MutableStateFlow<List<TopRatedResult>>(emptyList())
    val topRatedMovies: StateFlow<List<TopRatedResult>> = _topRatedMovies

    fun getTopRatedMovies() {
        viewModelScope.launch {
            _topRatedMovies.emit(apiClient.getTopRatedMovies().results)
        }
    }
}