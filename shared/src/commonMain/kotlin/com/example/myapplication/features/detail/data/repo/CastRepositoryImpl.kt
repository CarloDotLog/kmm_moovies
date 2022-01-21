package com.example.myapplication.features.detail.data.repo

import com.example.myapplication.features.detail.data.datasource.CastDatasource
import com.example.myapplication.features.detail.domain.entities.Cast
import com.example.myapplication.features.detail.domain.repo.ICastRepo

class CastRepositoryImpl(private val _castDatasource: CastDatasource) : ICastRepo {


    override suspend fun getCast(movieId: Int): List<Cast> {
        val casts = mutableListOf<Cast>()
        val models = _castDatasource.getMoviesCast(movieId)
        for (model in models)
            casts.add(model.asEntity())

        return casts
    }
}