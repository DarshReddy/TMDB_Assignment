package com.assignment.tmdb.network

import com.assignment.tmdb.data.TopRatedResponse
import retrofit2.http.GET

interface ApiClient {
    @GET("tv/top_rated")
    suspend fun getTopRatedMovies(): TopRatedResponse
}