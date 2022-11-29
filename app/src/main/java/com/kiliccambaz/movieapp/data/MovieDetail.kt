package com.kiliccambaz.movieapp.data

import com.google.gson.annotations.SerializedName

data class MovieDetail(val imdbId: String = "",val title: String = "",
                       @SerializedName("backdrop_path")
                       val backdropPath: String = "",
                       val revenue: Int = 0,
                       val genres: List<GenresItem>?,
                       val popularity: Double = 0.0,
                       val id: Int = 0,
                       val overview: String = "",
                       val posterPath: String = "",
                       @SerializedName("release_date")
                       val releaseDate: String = "",
                       @SerializedName("vote_average")
                       val voteAverage: Double = 0.0,
                       val tagline: String = "",
                       val homepage: String = "")