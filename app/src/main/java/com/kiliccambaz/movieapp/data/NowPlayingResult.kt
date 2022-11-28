package com.kiliccambaz.movieapp.data

data class NowPlayingResult(val dates: Dates,
                            val page: Int = 0,
                            val totalPages: Int = 0,
                            val results: List<ResultsItem>?,
                            val totalResults: Int = 0)