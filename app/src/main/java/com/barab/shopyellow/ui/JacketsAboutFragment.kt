package com.barab.shopyellow.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.barab.shopyellow.databinding.FragmentJacketsAboutBinding
import com.squareup.picasso.Picasso


class JacketsAboutFragment : Fragment() {
    lateinit var binding: FragmentJacketsAboutBinding
    lateinit var viewModel: JacketsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
    binding = FragmentJacketsAboutBinding.inflate(inflater)
        viewModel = ViewModelProvider(requireActivity())[JacketsViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt("ID")
        if(id != -1){
            id?.let {
                viewModel.getById(id)
            }
        }

//        viewModel.selectedJackets.observe(requireActivity()){
//            if(it != null){
//                binding.jackets = it
//                Picasso.get().load(it.img).into(binding.imageView2)
//            }
//        }
    }



}