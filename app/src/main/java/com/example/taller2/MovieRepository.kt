package com.example.taller2

import android.util.Log
import com.example.taller2.classes.MovieG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieRepository {
    private val api : InterfaceRetrofit
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(InterfaceRetrofit::class.java)
    }

    fun getPopularMovies(
        page: Int = 1,
        onSuccess: (movie: List<MovieG>) -> Unit,
        onError: () -> Unit

    ){
        api.getPopulars(page = page)
            .enqueue(object : Callback<GetMoviesResponse>{
                override fun onResponse(
                    call: Call<GetMoviesResponse>,
                    response: Response<GetMoviesResponse>
                ) {
                    if(response.isSuccessful){
                        val responseBody = response.body()
                        if (responseBody != null) {

                            onSuccess.invoke(responseBody.movies)
                        }else {
                            onError.invoke()
                        }

                    }else{
                        onError.invoke()
                    }
                }
                override fun onFailure(call: Call<GetMoviesResponse>, t: Throwable) {
                    onError.invoke()
                }

            })
    }

}