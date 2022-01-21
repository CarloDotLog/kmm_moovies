package com.example.myapplication.features.trending.api

import com.example.myapplication.features.trending.data.datasource.RemoteDatasource
import com.example.myapplication.features.trending.data.repo.TrendingRepositoryImpl
import com.example.myapplication.features.trending.domain.entity.Movie
import com.example.myapplication.features.trending.domain.usecase.GetTrendingMoviesUseCase

class TrendingMovies {
    suspend fun getTrendingMovies(): List<Movie> {
        return GetTrendingMoviesUseCase(TrendingRepositoryImpl(RemoteDatasource())).invoke(); // TODO: Check .invoke non andava scritto
    }
}