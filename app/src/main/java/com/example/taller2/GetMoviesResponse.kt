package com.example.taller2

import com.example.taller2.classes.MovieG
import com.google.gson.annotations.SerializedName

data class GetMoviesResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies : List<MovieG>,
    @SerializedName("total_pages") val pages : Int


)
