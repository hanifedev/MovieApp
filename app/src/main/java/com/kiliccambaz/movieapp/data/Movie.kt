package com.kiliccambaz.movieapp.data

import com.google.gson.annotations.SerializedName

data class Movie(val overview: String = "",
                 val title: String = "",
                 val genreIds: List<Integer>?,
                 val posterPath: String = "",
                 @SerializedName("backdrop_path")
                       val backdropPath: String = "",
                 @SerializedName("release_date")
                       val releaseDate: String = "",
                 val popularity: Double = 0.0,
                 @SerializedName("vote_average")
                       val voteAverage: Double = 0.0,
                 val id: Int = 0)