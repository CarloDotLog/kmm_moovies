package com.example.myapplication.android.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.android.R
import com.example.myapplication.features.trending.domain.entity.Movie
import com.squareup.picasso.Picasso

class MovieItemAdapter(): RecyclerView.Adapter<MovieItemAdapter.ViewHolder>() {

    var onItemClick: ((Movie) -> Unit)? = null
    var moviesList: ArrayList<Movie> = arrayListOf()

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        println("----> " + moviesList[position].posterPath)
        Log.d("URL IMAGE", moviesList[position].posterPath)
        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+moviesList[position].posterPath).into(holder.image);
        holder.title.text = moviesList[position].title.toString()

        // set on click listener
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(moviesList[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_movie_item, parent, false)
        return ViewHolder(v);
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image: ImageView = itemView.findViewById(R.id.image)
        val title: TextView = itemView.findViewById(R.id.title)

    }

}