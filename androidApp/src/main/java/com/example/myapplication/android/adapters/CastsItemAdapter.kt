package com.example.myapplication.android.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.android.R
import com.example.myapplication.features.detail.domain.entities.Cast
import com.squareup.picasso.Picasso

class CastsItemAdapter(): RecyclerView.Adapter<CastsItemAdapter.ViewHolder>() {
    var castsList: ArrayList<Cast> = arrayListOf()

    override fun getItemCount(): Int {
        return castsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        println("----> " + castsList[position].name)
        Log.d("URL IMAGE", castsList[position].profilePath)
        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+castsList[position].profilePath).into(holder.image);
        //holder.title.text = castsList[position].name.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_actor_item, parent, false)
        return ViewHolder(v);
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.ivActor)
        //val title: TextView = itemView.findViewById(R.id.title)
    }

}