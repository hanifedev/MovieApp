package com.kiliccambaz.movieapp.network

import com.kiliccambaz.movieapp.data.MovieDetail
import com.kiliccambaz.movieapp.data.NowPlayingResult
import com.kiliccambaz.movieapp.data.UpcomingResult
import com.kiliccambaz.movieapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("movie/upcoming?api_key=${Constants.API_KEY}")
    suspend fun getUpcomingMovies(): UpcomingResult

    @GET("movie/now_playing?api_key=${Constants.API_KEY}")
    suspend fun getNowPlayingMovies(): NowPlayingResult

    @GET("movie/{movieId}?api_key=${Constants.API_KEY}")
    suspend fun getMovieDetail(@Path("movieId") movieId: Int): MovieDetail

}