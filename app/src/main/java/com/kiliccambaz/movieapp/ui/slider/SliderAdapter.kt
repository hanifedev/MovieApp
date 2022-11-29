package com.kiliccambaz.movieapp.ui.slider

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
import com.kiliccambaz.movieapp.data.Movie
import com.kiliccambaz.movieapp.ui.home.AdapterClickListener

class SliderAdapter constructor(private val movieList: List<Movie>, private val adapterClickListener: AdapterClickListener) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    class SliderViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie, clickListener: AdapterClickListener) {
            binding.setVariable(BR.movie, movie)
            binding.setVariable(BR.clickListener, clickListener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, R.layout.row_item,parent,false)
        return SliderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie, adapterClickListener)
    }

    override fun getItemCount() = movieList.size

}

/*
@BindingAdapter("loadImage")
fun loadImage(imgView: ImageView, url: String?) {
    if (url != null) {
        Glide.with(imgView.context).load("https://image.tmdb.org/t/p/w500/$url").into(imgView)
    }
}*/