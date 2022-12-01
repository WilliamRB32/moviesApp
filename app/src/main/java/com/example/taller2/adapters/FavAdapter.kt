package com.example.taller2.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taller2.R
import com.example.taller2.classes.MovieG
import kotlinx.android.synthetic.main.favorites_row_item.view.*



class FavAdapter (private var movies: MutableList<MovieG>):RecyclerView.Adapter<FavAdapter.FavHolder>() {

    class FavHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun render(movie: MovieG){
            itemView.nameMovief.text= movie.title
            itemView.yearMovief.text=movie.releaseDate
            itemView.descriptionf.text = movie.overview



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.favorites_row_item,parent,false)
        return FavHolder(view)
    }

    override fun onBindViewHolder(holder: FavHolder, position: Int) {
        if (movies[position].favorite) {
            holder.render(movies[position])
        }
    }

    override fun getItemCount(): Int = movies.size

    fun updateMovies(movies: List<MovieG>){
        this.movies.clear()
        this.movies.addAll(movies)

        notifyDataSetChanged()
    }

}