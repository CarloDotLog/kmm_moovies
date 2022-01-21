package com.example.myapplication.features.detail.domain.repo

import com.example.myapplication.features.detail.domain.entities.Cast

interface ICastRepo {
    suspend fun getCast(movieId: Int): List<Cast>
}