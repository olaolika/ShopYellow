package com.barab.shopyellow.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.barab.shopyellow.JacketsListAdapter
import com.barab.shopyellow.R
import com.barab.shopyellow.databinding.FragmentMainBinding
import com.barab.shopyellow.room.JacketsData
import kotlin.random.Random

class JacketsListFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private lateinit var viewModel: JacketsViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = JacketsListAdapter()
        adapter.itemClick {
            val bundle = Bundle()
            bundle.putInt("ID", it.id)
            Navigation.findNavController(binding.root).navigate(
                R.id.action_SecondFragment_to_jacketsAboutFragment,
                bundle
            )
        }
        viewModel.getAll()?.observe(requireActivity()){
            if(it.isEmpty()){
                val list = initJacketsList()
                list.forEach { jackets ->
                    viewModel.insert(jackets)
                }
            }

            adapter.items = it
        }

        binding.jacketsRecyclerView.adapter = adapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initJacketsList(): List<JacketsData>{

        val result = arrayListOf<JacketsData>()
        for (i in 0..100) {
            result.add(
                JacketsData(
                i,
                "Name$i", Random.nextDouble(500.0),
                    "description$i",
                    false,
            )
            )
        }
        return result
    }
}