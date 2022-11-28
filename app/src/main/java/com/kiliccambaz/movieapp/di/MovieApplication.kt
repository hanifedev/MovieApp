package com.kiliccambaz.movieapp.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//hilt must contain app class
@HiltAndroidApp
class MovieApplication: Application() {
}