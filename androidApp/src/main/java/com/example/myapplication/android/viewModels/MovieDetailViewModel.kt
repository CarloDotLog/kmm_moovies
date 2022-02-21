package com.example.myapplication.android.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.features.detail.api.MovieCast
import com.example.myapplication.features.detail.domain.entities.Cast
import com.example.myapplication.features.trending.api.TrendingMovies
import com.example.myapplication.features.trending.domain.entity.Movie
import kotlinx.coroutines.*
import java.lang.Exception

class MovieDetailViewModel : ViewModel() {

    fun getTrendingMovies(): LiveData<List<Movie>>{
        return liveData {
            try {
                val data = TrendingMovies().getTrendingMovies()
                emit(data)
            } catch (e: Exception){
                // emit error state
            }
        }
    }

    fun getCasts(movieId: Long): LiveData<List<Cast>> {
        return liveData {
            try {
                val data = MovieCast().getMovieCast(movieId.toInt()) // loadCasts is a suspend function.
                emit(data)
            } catch (e: Exception){
                // emit error state
            }
        }
    }

}