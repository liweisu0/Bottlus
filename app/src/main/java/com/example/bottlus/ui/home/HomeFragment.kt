package com.example.bottlus.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bottlus.R
import com.example.bottlus.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val gridItems = listOf(
            GridItem(R.drawable.ic_launcher_foreground, "Item 1", "Article content 1"),
            GridItem(R.drawable.ic_launcher_foreground, "Item 2", "Article content 2"),
            // Add all 9 items here
        )

        binding.gridRecyclerView.adapter = GridAdapter(gridItems) { item ->
            findNavController().navigate(
                HomeFragmentDirections.actionNavigationHomeToDetailFragment(item)
            )
        }

        binding.gridRecyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}