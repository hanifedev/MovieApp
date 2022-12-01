package com.kiliccambaz.movieapp.data

import com.google.gson.annotations.SerializedName

data class UpcomingResult(val page: Int = 0,
                          @SerializedName("total_pages")
                          val totalPages: Int = 0,
                          val results: List<Movie>?,
                          val totalResults: Int = 0)