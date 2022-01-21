package com.example.myapplication.features.detail.api

import com.example.myapplication.features.detail.data.datasource.CastDatasource
import com.example.myapplication.features.detail.data.repo.CastRepositoryImpl
import com.example.myapplication.features.detail.domain.entities.Cast
import com.example.myapplication.features.detail.domain.usecase.GetCastUseCase

class MovieCast {
    suspend fun getMovieCast(movieID: Int): List<Cast> {
        return GetCastUseCase(CastRepositoryImpl(CastDatasource()), movieID).invoke();
    }
}