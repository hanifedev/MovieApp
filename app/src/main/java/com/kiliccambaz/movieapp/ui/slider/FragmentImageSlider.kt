package com.kiliccambaz.movieapp.ui.slider

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.kiliccambaz.movieapp.R
import com.kiliccambaz.movieapp.data.ResultsItem
import me.relex.circleindicator.CircleIndicator

class FragmentImageSlider : Fragment() {

    private var imagesModel:ResultsItem? = null
    lateinit var viewPagerAdapter: ImageSlideAdapter
    lateinit var indicator: CircleIndicator
    lateinit var viewPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_image_slider, container, false)
        root.findViewById<ViewPager>(R.id.viewpager)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imagesModel?.let{
         //   viewPagerAdapter = ImageSlideAdapter(requireContext(), it)
            viewPager.adapter = viewPagerAdapter
            indicator = requireView().findViewById(R.id.indicator) as CircleIndicator
            indicator.setViewPager(viewPager)
        }
    }

}