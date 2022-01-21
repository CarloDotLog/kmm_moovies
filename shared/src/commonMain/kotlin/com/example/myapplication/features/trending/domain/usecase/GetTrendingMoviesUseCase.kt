package com.example.myapplication.features.trending.domain.usecase

import com.example.myapplication.features.trending.domain.entity.Movie
import com.example.myapplication.features.trending.domain.repo.ITrendingRepository

class GetTrendingMoviesUseCase(var repository: ITrendingRepository) {
    suspend operator fun invoke(): List<Movie> = repository.getTrendingMovies()
}

// GetTrendingMoviesUseCase()
