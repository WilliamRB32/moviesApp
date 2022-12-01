package com.example.taller2


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface InterfaceRetrofit {

    @GET("movie/popular")
    fun getPopulars(
        @Query("api_key") apiKey: String = "7f0743e48ee2855959b4e800d078c9c7",
        @Query("page") page: Int
    ): Call<GetMoviesResponse>



}