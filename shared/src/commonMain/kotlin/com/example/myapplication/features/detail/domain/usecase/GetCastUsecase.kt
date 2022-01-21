package com.example.myapplication.features.detail.domain.usecase

import com.example.myapplication.features.detail.domain.entities.Cast
import com.example.myapplication.features.detail.domain.repo.ICastRepo


class GetCreditsUseCase(var repository: ICastRepo, var movieId: Int) {
    suspend operator fun invoke(): List<Cast> = repository.getCast(movieId)
}