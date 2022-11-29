package com.kiliccambaz.movieapp.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.kiliccambaz.movieapp.data.Movie
import com.kiliccambaz.movieapp.data.MovieDetail
import com.kiliccambaz.movieapp.data.NowPlayingResult
import com.kiliccambaz.movieapp.network.ApiService
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val apiService: ApiService) {

    fun getUpcomingMovies(): LiveData<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20
            ),
            pagingSourceFactory = { MoviePagingSource(apiService) }
        ).liveData
    }

    suspend fun getNowPlayingMovies(): NowPlayingResult {
        return apiService.getNowPlayingMovies()
    }

    suspend fun getMovieDetail(movieId: Int): MovieDetail {
        return apiService.getMovieDetail(movieId)
    }
}