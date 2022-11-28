package com.kiliccambaz.movieapp.repository

import com.kiliccambaz.movieapp.data.NowPlayingResult
import com.kiliccambaz.movieapp.data.UpcomingResult
import com.kiliccambaz.movieapp.network.ApiService

class MoviesRepository constructor(private val apiService: ApiService) {


    suspend fun getUpcomingMovies(): UpcomingResult {
        return apiService.getUpcomingMovies()
    }

    suspend fun getNowPlayingMovies(): NowPlayingResult {
        return apiService.getNowPlayingMovies()
    }
}