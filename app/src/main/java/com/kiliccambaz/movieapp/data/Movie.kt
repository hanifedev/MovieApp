package com.kiliccambaz.movieapp.data

import com.google.gson.annotations.SerializedName

data class Movie(val overview: String = "",
                 val title: String = "",
                 @SerializedName("backdrop_path")
                       val backdropPath: String = "",
                 @SerializedName("release_date")
                       val releaseDate: String = "",
                 @SerializedName("vote_average")
                       val voteAverage: Double = 0.0,
                 val id: Int = 0)