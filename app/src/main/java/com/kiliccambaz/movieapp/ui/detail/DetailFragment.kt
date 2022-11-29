package com.kiliccambaz.movieapp.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.kiliccambaz.movieapp.R
import com.kiliccambaz.movieapp.databinding.FragmentDetailBinding
import com.kiliccambaz.movieapp.databinding.FragmentHomeBinding
import com.kiliccambaz.movieapp.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val viewModel by viewModels<DetailViewModel>()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movieId = args.movieId
        viewModel.getMovieDetail(movieId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(layoutInflater)
        viewModel.movieDetail.observe(viewLifecycleOwner) {
            it?.let {
                _binding!!.movie = it
            }
        }
        return _binding!!.root
    }

}