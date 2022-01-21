package com.example.myapplication.features.trending.data.model

import com.example.myapplication.features.trending.domain.entity.MediaType
import com.example.myapplication.features.trending.domain.entity.Movie
import com.example.myapplication.features.trending.domain.entity.TrendingResponseEntity
import kotlinx.serialization.*
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.*

@Serializable
data class TrendingResponseModel(
    val page: Long,
    @SerialName("results")
    val movies: List<MovieModel>,

    @SerialName("total_pages")
    val totalPages: Long,

    @SerialName("total_results")
    val totalResults: Long

)

@Serializable
data class MovieModel(
    @SerialName("original_language")
    val originalLanguageModel: String,
    @SerialName("original_title")
    val originalTitle: String? = null,
    @SerialName("poster_path")
    val posterPath: String,
    val video: Boolean? = null,
    @SerialName("vote_average")
    val voteAverage: Double,
    val overview: String,
    @SerialName("release_date")
    val releaseDate: String? = null,
    @SerialName("vote_count")
    val voteCount: Long,
    val title: String? = null,
    val adult: Boolean? = null,
    @SerialName("backdrop_path")
    val backdropPath: String,
    val id: Long,
    @SerialName("genre_ids")
    val genreIDS: List<Long>,
    val popularity: Double,
    @SerialName("original_name")
    val originalName: String? = null,
    @SerialName("first_air_date")
    val firstAirDate: String? = null,
    @SerialName("origin_country")
    val originCountry: List<String>? = null,
    val name: String? = null
) {
    fun asEntity(): Movie{
        return Movie(originalLanguageModel, originalTitle, posterPath, video, voteAverage, overview,
            releaseDate, voteCount, title,adult, backdropPath, id, genreIDS, popularity,
            originalName, firstAirDate, originCountry, name)
    }
}

@Serializable
enum class MediaTypeModel(val value: String) {
    Movie("movie"),
    Tv("tv");

    fun asEntity(): MediaType {
        return MediaType.valueOf(value)
    }

    companion object : KSerializer<MediaTypeModel> {
        override val descriptor: SerialDescriptor
            get() {
                return PrimitiveSerialDescriptor("quicktype.MediaType", PrimitiveKind.STRING)
            }

        override fun deserialize(decoder: Decoder): MediaTypeModel =
            when (val value = decoder.decodeString()) {
                "movie" -> Movie
                "tv" -> Tv
                else -> throw IllegalArgumentException("MediaType could not parse: $value")
            }

        override fun serialize(encoder: Encoder, value: MediaTypeModel) {
            return encoder.encodeString(value.value)
        }
    }
}