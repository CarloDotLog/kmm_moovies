package com.example.myapplication.features.detail.domain.entities

class CreditsResponse (val id: Int, val cast: List<Cast>)

class Cast(
    val profile_path: String,
    val name: String
)