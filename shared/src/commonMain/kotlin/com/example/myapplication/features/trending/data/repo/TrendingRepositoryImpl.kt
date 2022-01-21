package com.example.myapplication.features.trending.data.repo

import com.example.myapplication.features.trending.data.datasource.RemoteDatasource
import com.example.myapplication.features.trending.domain.entity.Movie
import com.example.myapplication.features.trending.domain.repo.ITrendingRepository

class TrendingRepositoryImpl(private val _remoteDatasource: RemoteDatasource) : ITrendingRepository {

    override suspend fun getTrendingMovies(): List<Movie> {
        val movies = mutableListOf<Movie>()
        val models = _remoteDatasource.getTrendingMovies()
        for (model in models)
            movies.add(model.asEntity())

        return movies
    }

}