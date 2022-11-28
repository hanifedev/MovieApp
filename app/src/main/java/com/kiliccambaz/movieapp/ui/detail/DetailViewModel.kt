package com.kiliccambaz.movieapp.ui.detail

import androidx.lifecycle.ViewModel
import com.kiliccambaz.movieapp.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val moviesRepository: MoviesRepository): ViewModel() {
    // TODO: Implement the ViewModel
}