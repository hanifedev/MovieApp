package com.kiliccambaz.movieapp.ui.home

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.kiliccambaz.movieapp.data.Movie
import com.kiliccambaz.movieapp.data.NowPlayingResult
import com.kiliccambaz.movieapp.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val moviesRepository: MoviesRepository): ViewModel() {

    val upcomingMovies : LiveData<PagingData<Movie>> = moviesRepository.getUpcomingMovies().cachedIn(viewModelScope)

    private val _nowPlayingMovies: MutableLiveData<NowPlayingResult?> = MutableLiveData()
    val nowPlayingMovies : LiveData<NowPlayingResult?> = _nowPlayingMovies

    fun getNowPlayingMovies() {
        viewModelScope.launch {
            _nowPlayingMovies.value = moviesRepository.getNowPlayingMovies()
        }
    }

}