package com.kiliccambaz.movieapp.data

data class MovieDetail(val imdbId: String = "",val title: String = "",
                       val backdropPath: String = "",
                       val revenue: Int = 0,
                       val genres: List<GenresItem>?,
                       val popularity: Double = 0.0,
                       val id: Int = 0,
                       val voteCount: Int = 0,
                       val overview: String = "",
                       val originalTitle: String = "",
                       val runtime: Int = 0,
                       val posterPath: String = "",
                       val releaseDate: String = "",
                       val voteAverage: Double = 0.0,
                       val tagline: String = "",
                       val homepage: String = "")