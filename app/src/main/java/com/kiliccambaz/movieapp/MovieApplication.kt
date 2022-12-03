package com.kiliccambaz.movieapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//hilt must contain app class
@HiltAndroidApp
class MovieApplication: Application() {
}