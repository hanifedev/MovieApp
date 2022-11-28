package com.kiliccambaz.movieapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kiliccambaz.movieapp.BR
import com.kiliccambaz.movieapp.R
import com.kiliccambaz.movieapp.data.ResultsItem

class HomeAdapter constructor(private val movieList: List<ResultsItem>, private val adapterClickListener: AdapterClickListener) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: ResultsItem, clickListener: AdapterClickListener) {
            binding.setVariable(BR.movie, movie)
            binding.setVariable(BR.clickListener, clickListener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, R.layout.row_item,parent,false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie, adapterClickListener)
    }

    override fun getItemCount() = movieList.size

}

@BindingAdapter("loadImage")
fun loadImage(image: ImageView, url: String?) {
    if (url != null) {
        Glide.with(image.context).load("https://image.tmdb.org/t/p/w500/$url").into(image)
    }
}