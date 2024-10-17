package com.assignment.tmdb.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopRatedResponse(
    val results: List<TopRatedResult>
)

@JsonClass(generateAdapter = true)
data class TopRatedResult(
    val id: Int,
    val name: String,
    @Json(name = "vote_average")
    val voteAverage: Float,
    @Json(name = "poster_path")
    val posterPath: String,
    @Json(name = "first_air_date")
    val firstAirDate: String
) {
    val imageUrl: String
        get() = "https://image.tmdb.org/t/p/w500$posterPath"
    val airedYear: String
        get() = firstAirDate.split("-").first()
}