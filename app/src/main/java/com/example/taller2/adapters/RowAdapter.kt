package com.example.taller2.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.taller2.InterfaceFavorites
import com.example.taller2.classes.MovieG
import com.example.taller2.R
import kotlinx.android.synthetic.main.movie_row_item.view.*

class RowAdapter(private var movies: MutableList<MovieG>, private val listener:InterfaceFavorites) : RecyclerView.Adapter<RowAdapter.ViewHolder>(){

     class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

         fun render(movie: MovieG, listener: InterfaceFavorites){
            itemView.nameMovie.text=movie.title
             itemView.yearMovie.text=movie.releaseDate
            itemView.description.text=movie.overview
             itemView.favButton.setOnClickListener{

                listener.addToFavorites(movie.id)

             }
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w154${movie.posterPath}")
                .transform(CenterCrop())
                .into(itemView.movie_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.movie_row_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(movies[position],listener)
    }

    override fun getItemCount(): Int = movies.size

    fun updateMovies(movies: List<MovieG>){
        this.movies.clear()
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }
}