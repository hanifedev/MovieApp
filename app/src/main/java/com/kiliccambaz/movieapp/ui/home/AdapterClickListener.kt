package com.kiliccambaz.movieapp.ui.home

import android.view.View
import com.kiliccambaz.movieapp.data.ResultsItem
import com.kiliccambaz.movieapp.data.UpcomingResult

interface AdapterClickListener {

    fun onRecyclerViewItemClick(movie : ResultsItem)

}