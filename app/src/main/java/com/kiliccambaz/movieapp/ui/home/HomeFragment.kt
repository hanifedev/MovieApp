package com.kiliccambaz.movieapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kiliccambaz.movieapp.data.Movie
import com.kiliccambaz.movieapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), AdapterClickListener {

    private var _binding: FragmentHomeBinding? = null
    val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getUpcomingMovies()
        viewModel.getNowPlayingMovies()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        viewModel.upcomingMovies.observe(viewLifecycleOwner) {
            it?.let {
                it.results?.let { movies -> setRecyclerItems(movies) }
            }
        }

        return _binding!!.root
    }

    private fun setRecyclerItems(data: List<Movie>) {
        val mAdapter = HomeAdapter(data, this)
        _binding!!.rvHome.layoutManager = LinearLayoutManager(context)
        _binding!!.rvHome.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        _binding!!.rvHome.adapter = mAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onRecyclerViewItemClick(id: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(id)
        findNavController().navigate(action)
    }

}