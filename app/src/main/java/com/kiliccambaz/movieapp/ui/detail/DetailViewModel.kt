package com.kiliccambaz.movieapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kiliccambaz.movieapp.data.MovieDetail
import com.kiliccambaz.movieapp.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val moviesRepository: MoviesRepository): ViewModel() {

    private val _movieDetail: MutableLiveData<MovieDetail?> = MutableLiveData()
    val movieDetail : LiveData<MovieDetail?> = _movieDetail

    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch {
            _movieDetail.value = moviesRepository.getMovieDetail(movieId)
        }
    }
}