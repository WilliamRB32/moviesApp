package com.example.taller2.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taller2.InterfaceFavorites
import com.example.taller2.R
import com.example.taller2.adapters.FavAdapter
import com.example.taller2.adapters.RowAdapter
import com.example.taller2.classes.Movie
import com.example.taller2.classes.MovieG
import com.example.taller2.viewModel.MoviesViewModel
import kotlinx.android.synthetic.main.fragment_favorites.*


class FragmentFavorites : Fragment() {

    private val moviesViewModel: MoviesViewModel by activityViewModels()
    private lateinit var favoriteMoviesAdapter: FavAdapter
    private lateinit var favoriteMovies: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_favorites,container,false)

        favoriteMovies = view.findViewById(R.id.rvFMovies)
        favoriteMovies.layoutManager = LinearLayoutManager(context)
        favoriteMoviesAdapter = FavAdapter(mutableListOf())
        favoriteMovies.adapter = favoriteMoviesAdapter




        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesViewModel.currentModel.observe(viewLifecycleOwner){
            onFavoriteMoviesFetched(it)
        }
    }

    private fun onFavoriteMoviesFetched(movies: List<MovieG>){
        favoriteMoviesAdapter.updateMovies(movies)
    }

}