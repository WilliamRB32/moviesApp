package com.example.taller2.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taller2.MovieRepository
import com.example.taller2.classes.Movie
import com.example.taller2.classes.MovieG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel : ViewModel() {



    private val _currentModel = MutableLiveData<List<MovieG>>()
    var currentModel : LiveData<List<MovieG>> = _currentModel
    

    fun getMoviesFromApi(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                MovieRepository.getPopularMovies(
                    onSuccess = ::addPopularMovies,
                    onError = ::onError
                )
            }
        }
    }

    private fun addPopularMovies(movies : List<MovieG>){
        _currentModel.value = movies
        Log.d("Peliculas",movies.toString())
    }
    private fun onError(){
        Log.d("MoviesViewModelError", "ERROR")
    }

    fun changeToFav(id: Long){
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                for (movie in _currentModel.value!!) {
                    if (movie.id == id) {
                        Log.d("A favorito", movie.title)
                        movie.favorite = true
                        Log.d("confirm", movie.favorite.toString())

                    }
                }
            }
        }
    }

    fun getFavoriteMovies(): List<MovieG> {
        var favoriteMovies = listOf<MovieG>()
        for (movie in _currentModel.value!!){
            if(movie.favorite){
                favoriteMovies += movie
            }
        }
        return favoriteMovies
    }

    override fun onCleared() {
        super.onCleared()

    }
}