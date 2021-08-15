package com.mistplay.challenge.ui.main.games

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mistplay.challenge.databinding.FragmentGamesBinding
import com.mistplay.challenge.ui.main.games.adapters.CategoryAdapter
import com.mistplay.challenge.ui.main.games.viewmodel.GamesViewModel

/**
 * Games Tab Screen
 *
 * Created by Pramod Selvaraj on 13/08/2021.
 */
class GamesFragment : Fragment() {
    private lateinit var gamesViewModel: GamesViewModel
    private var _binding: FragmentGamesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        gamesViewModel =
            ViewModelProvider(this).get(GamesViewModel::class.java)

        _binding = FragmentGamesBinding.inflate(inflater, container, false)
        /*Specify the current activity as the lifecycle owner.*/
        binding.lifecycleOwner = this

        val root: View = binding.root

        fetchGameCategories()
        showGameCategories()
        return root
    }

    /*Function for Fetching All The Game Categories From Repository*/
    private fun fetchGameCategories() {
        context?.let { gamesViewModel.fetchAllCategories(it) }
    }

    /*Function for Populating The Games Categories In The View*/
    private fun showGameCategories() {
        val bookCategoryAdapter = CategoryAdapter()
        binding.recyclerViewCategory.adapter = bookCategoryAdapter
        gamesViewModel.mediatorLiveData.observe(viewLifecycleOwner, {
            bookCategoryAdapter.submitList(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}