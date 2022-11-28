package com.kiliccambaz.movieapp.ui.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kiliccambaz.movieapp.data.NowPlayingResult
import com.kiliccambaz.movieapp.data.UpcomingResult
import com.kiliccambaz.movieapp.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val moviesRepository: MoviesRepository): ViewModel() {

    private val _upcomingMovies: MutableLiveData<UpcomingResult?> = MutableLiveData()
    val upcomingMovies : LiveData<UpcomingResult?> = _upcomingMovies

    private val _nowPlayingMovies: MutableLiveData<NowPlayingResult?> = MutableLiveData()
    val nowPlayingMovies : LiveData<NowPlayingResult?> = _nowPlayingMovies

    fun getUpcomingMovies() {
        viewModelScope.launch {
            _upcomingMovies.value = moviesRepository.getUpcomingMovies()
        }
    }

    fun getNowPlayingMovies() {
        viewModelScope.launch {
            _nowPlayingMovies.value = moviesRepository.getNowPlayingMovies()
        }
    }

}