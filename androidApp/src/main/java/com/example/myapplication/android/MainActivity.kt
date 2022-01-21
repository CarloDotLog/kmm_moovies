package com.example.myapplication.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Greeting
import android.widget.TextView
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
    lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.text_view)
        tv.text = greet()

        getTrendingMovies()
    }

    fun getTrendingMovies(){
        GlobalScope.launch(Dispatchers.Main){
            response = TrendingMovies().getTrendingMovies()
            tv.text = ""
        }
    }
}
