package com.kiliccambaz.movieapp.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kiliccambaz.movieapp.data.Movie
import com.kiliccambaz.movieapp.network.ApiService
import timber.log.Timber

class MoviePagingSource (private val apiService : ApiService) :
    PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPage = params.key ?: DEFAULT_PAGE
            val movieListResponse = apiService.getUpcomingMovies(nextPage)
            LoadResult.Page(
                data = movieListResponse.results!!,
                prevKey = if(nextPage == DEFAULT_PAGE) null else nextPage-1 ,
                nextKey = if(nextPage < movieListResponse.totalPages) movieListResponse.page.plus(1) else null
            )
        } catch (e: Exception) {
            Timber.e("Error in paging source load func. ${e.message}")
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val DEFAULT_PAGE = 1
    }

}