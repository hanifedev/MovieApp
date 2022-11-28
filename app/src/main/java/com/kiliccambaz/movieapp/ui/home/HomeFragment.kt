package com.kiliccambaz.movieapp.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.kiliccambaz.movieapp.data.ResultsItem
import com.kiliccambaz.movieapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.getUpcomingMovies()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        viewModel.upcomingMovies.observe(viewLifecycleOwner, Observer {
            it?.let {
                it.results?.let { movies -> setRecyclerItems(movies) }
            }
        })
        return _binding!!.root
    }

    private fun setRecyclerItems(data: List<ResultsItem>) {
        val mAdapter = HomeAdapter(data, object : AdapterClickListener {

            override fun onRecyclerViewItemClick(movie: ResultsItem) {
                val navigation =
                    HomeFragmentDirections.actionHomeFragmentToDetailFragment(movie.id)
                Navigation.findNavController(requireView()).navigate(navigation)
            }
        })
        _binding!!.rvHome.layoutManager = LinearLayoutManager(context)
        _binding!!.rvHome.adapter = mAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}