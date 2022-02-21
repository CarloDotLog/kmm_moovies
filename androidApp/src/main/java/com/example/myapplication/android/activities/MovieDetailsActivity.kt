package com.example.myapplication.android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.android.viewModels.MovieDetailViewModel
import com.example.myapplication.android.R
import com.example.myapplication.android.adapters.CastsItemAdapter
import com.example.myapplication.features.detail.domain.entities.Cast
import com.squareup.picasso.Picasso

class MovieDetailsActivity() : AppCompatActivity() {

    lateinit var rvCasts: RecyclerView
    lateinit var adapter: CastsItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val movieId = intent.getLongExtra("EXTRA_MOVIE_ID", 0)
        val movieTitle = intent.getStringExtra("EXTRA_MOVIE_NAME")
        val moviePoster = intent.getStringExtra("EXTRA_MOVIE_IMG_URL")

        // init UI
        initUI(movieId, movieTitle ?: "title", moviePoster ?: "poster_url")

        // Use the 'by viewModels()' Kotlin property delegate
        // from the activity-ktx artifact
        val model: MovieDetailViewModel by viewModels()

        model.getCasts(movieId).observe(this, Observer<List<Cast>>{ casts ->
            // update UI
            updateUi(casts)
        })

    }

    private fun initUI(movieId: Long, movieTitle: String, moviePoster: String){
        rvCasts = findViewById(R.id.rvActors)
        rvCasts.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        adapter = CastsItemAdapter()
        rvCasts.adapter = adapter

        val ivPoster = findViewById<ImageView>(R.id.ivLocandina)
        Picasso.get().load("https://image.tmdb.org/t/p/w500/$moviePoster").into(ivPoster);
        findViewById<TextView>(R.id.tv_desc).setText(movieTitle)

    }

    private fun updateUi(casts: List<Cast>) {
        // update rv
        adapter.castsList = casts as ArrayList<Cast>
        adapter.notifyDataSetChanged()
    }
}