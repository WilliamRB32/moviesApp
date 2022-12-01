package com.example.taller2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taller2.*
import com.example.taller2.adapters.RowAdapter
import com.example.taller2.classes.MovieG
import com.example.taller2.viewModel.MoviesViewModel


class FragmentPopular : Fragment(), InterfaceFavorites {

    private lateinit var popularMoviesAdapter: RowAdapter
    private lateinit var popularMovies: RecyclerView

    private val moviesViewModel: MoviesViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        moviesViewModel.getMoviesFromApi()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_popular,container,false)

        popularMovies = view.findViewById(R.id.rvMovies)
        popularMovies.layoutManager = LinearLayoutManager(context)
        popularMoviesAdapter = RowAdapter(mutableListOf(),this)
        popularMovies.adapter = popularMoviesAdapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesViewModel.currentModel.observe(viewLifecycleOwner){
            onPopularMoviesFetched(it)
        }
    }

    private fun onPopularMoviesFetched(movies: List<MovieG>){
       popularMoviesAdapter.updateMovies(movies)
    }


    override fun addToFavorites(id: Long) {
        moviesViewModel.changeToFav(id)
    }
}