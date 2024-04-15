package com.example.nav_arch_component.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.nav_arch_component.R
import com.example.nav_arch_component.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_home,
                container,
                false
            )


        binding.button.setOnClickListener {
            val name = binding.editText.text.toString()
            val bundle = bundleOf(
                "input" to name
            )
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToLoginFragment(),
            )
        }
        return binding.root
    }


}