package com.example.myapplication.features.detail.data.model

import com.example.myapplication.features.detail.domain.entities.Cast
import com.example.myapplication.features.trending.domain.entity.MediaType
import kotlinx.serialization.Serializable

@Serializable
class CastModel(val profile_path: String?,
                val name: String) {

    fun asEntity(): Cast {
        return Cast(profile_path ?: "", name)
    }
}