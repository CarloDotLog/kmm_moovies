package com.example.myapplication.features.trending.domain.repo

import com.example.myapplication.features.trending.domain.entity.Movie

interface ITrendingRepository {
    suspend fun getTrendingMovies(): List<Movie>
}