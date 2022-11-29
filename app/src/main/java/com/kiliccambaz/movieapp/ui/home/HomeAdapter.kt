package com.kiliccambaz.movieapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kiliccambaz.movieapp.BR
import com.kiliccambaz.movieapp.R
import com.kiliccambaz.movieapp.data.Movie

class HomeAdapter constructor(private val adapterClickListener: AdapterClickListener) :
    PagingDataAdapter<Movie, HomeAdapter.HomeViewHolder>(DiffUtilCallBack) {

    class HomeViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie, clickListener: AdapterClickListener) {
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
        val movie = getItem(position)
        movie.let {
            holder.bind(movie!!,adapterClickListener)
        }
    }

    object DiffUtilCallBack : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

}

@BindingAdapter("loadImage")
fun loadImage(image: ImageView, url: String?) {
    if (url != null) {
        Glide.with(image.context).load("https://image.tmdb.org/t/p/w500/$url").into(image)
    }
}