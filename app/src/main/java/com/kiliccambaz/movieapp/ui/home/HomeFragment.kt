package com.kiliccambaz.movieapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.kiliccambaz.movieapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment(), AdapterClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getNowPlayingMovies()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvAdapter = HomeAdapter( this)
        _binding!!.rvHome.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
            adapter = rvAdapter
        }
        viewModel.getUpcomingMovies().observe(viewLifecycleOwner) { movies ->
            rvAdapter.submitData(viewLifecycleOwner.lifecycle,movies)
        }

        viewModel.nowPlayingMovies.observe(viewLifecycleOwner) { nowPlaying ->
            if (nowPlaying != null) {
                nowPlaying.results?.let {
                    val sliderAdapter = SliderAdapter( nowPlaying.results.take(5),this)
                    _binding!!.vpSlider.adapter = sliderAdapter
                    val tabLayoutMediator = TabLayoutMediator(
                        _binding!!.tlDots, _binding!!.vpSlider, true
                    ) { _, _ -> }
                    tabLayoutMediator.attach()
                }
            }
        }
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