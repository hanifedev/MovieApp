package com.kiliccambaz.movieapp.repository

import com.kiliccambaz.movieapp.data.MovieDetail
import com.kiliccambaz.movieapp.data.NowPlayingResult
import com.kiliccambaz.movieapp.data.UpcomingResult
import com.kiliccambaz.movieapp.network.ApiService
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val apiService: ApiService) {


    suspend fun getUpcomingMovies(): UpcomingResult {
        return apiService.getUpcomingMovies()
    }

    suspend fun getNowPlayingMovies(): NowPlayingResult {
        return apiService.getNowPlayingMovies()
    }

    suspend fun getMovieDetail(movieId: Int): MovieDetail {
        return apiService.getMovieDetail(movieId)
    }
}