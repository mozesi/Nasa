package com.kauzgana.nasa.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.kauzgana.nasa.R
import com.kauzgana.nasa.databinding.FragmentHomeBinding
import com.kauzgana.nasa.models.HomeViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentHomeBinding  = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)

        val viewmodel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.lifecycleOwner = this
        binding.homeViewModel =viewmodel

        return binding.root
    }

}