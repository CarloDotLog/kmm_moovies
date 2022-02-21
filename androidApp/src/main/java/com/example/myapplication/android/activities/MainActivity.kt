package com.example.myapplication.android.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.myapplication.Greeting
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.android.activities.MovieDetailsActivity
import com.example.myapplication.android.adapters.MovieItemAdapter
import com.example.myapplication.features.trending.api.TrendingMovies
import com.example.myapplication.features.trending.domain.entity.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import com.example.myapplication.android.R
import com.example.myapplication.android.viewModels.MovieDetailViewModel
import com.example.myapplication.features.detail.domain.entities.Cast

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    lateinit var rvMovies: RecyclerView

    lateinit var adapter: MovieItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model: MovieDetailViewModel by viewModels()

        rvMovies = findViewById(R.id.rvMovies)
        rvMovies.layoutManager = GridLayoutManager(this,2)
        adapter = MovieItemAdapter()
        rvMovies.adapter = adapter
        adapter.onItemClick = {
            Log.d("MOVIE NAME", "${it.title ?: it.name}")
            // navigate
            val intent = Intent(this, MovieDetailsActivity::class.java).apply {
                putExtra("EXTRA_MOVIE_ID", it.id)
                putExtra("EXTRA_MOVIE_NAME", it.title ?: it.name)
                putExtra("EXTRA_MOVIE_IMG_URL", it.posterPath)
            }
            startActivity(intent)
        }

        model.getTrendingMovies().observe(this, Observer<List<Movie>>{
            movies -> updateUi(movies)
        })

    }

    private fun updateUi(movies: List<Movie>) {
        adapter.moviesList = movies as ArrayList<Movie>
        adapter.notifyDataSetChanged()
    }
}
