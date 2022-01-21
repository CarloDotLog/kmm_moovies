package com.example.myapplication.features.trending.domain.entity

import kotlinx.serialization.Serializable


open class TrendingResponseEntity(
    open val movies: List<Movie>,
)

open class Movie(
  open val originalLanguage: String,
  open val originalTitle: String? = null,
  open val posterPath: String,
  open val video: Boolean? = null,
  open val voteAverage: Double,
  open val overview: String,
  open val releaseDate: String? = null,
  open val voteCount: Long,
  open val title: String? = null,
  open val adult: Boolean? = null,
  open val backdropPath: String,
  open val id: Long,
  open val genreIDS: List<Long>,
  open val popularity: Double,
  open val originalName: String? = null,
  open val firstAirDate: String? = null,
  open val originCountry: List<String>? = null,
  open val name: String? = null
)

enum class MediaType(val value: String) {
    Movie("movie"),
    Tv("tv");
}
