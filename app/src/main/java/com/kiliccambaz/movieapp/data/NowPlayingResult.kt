package com.kiliccambaz.movieapp.data

data class NowPlayingResult(val page: Int = 0,
                            val totalPages: Int = 0,
                            val results: List<Movie>?,
                            val totalResults: Int = 0)