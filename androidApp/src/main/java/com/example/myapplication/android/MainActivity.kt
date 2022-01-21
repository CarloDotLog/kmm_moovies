package com.example.myapplication.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import com.example.myapplication.Greeting
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.features.trending.api.TrendingMovies
import com.example.myapplication.features.trending.domain.entity.Movie
import com.example.myapplication.features.trending.domain.entity.TrendingResponseEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    lateinit var response: List<Movie>
    lateinit var rvMovies: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies = findViewById(R.id.rvMovies)

        getTrendingMovies()

    }

    fun getTrendingMovies(){
        GlobalScope.launch(Dispatchers.Main){
            response = TrendingMovies().getTrendingMovies()
            rvMovies.layoutManager = GridLayoutManager(applicationContext, 2)
            rvMovies.adapter = MovieItemAdapter(response as ArrayList<Movie>)
        }
    }
}
