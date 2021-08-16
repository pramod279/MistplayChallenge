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
    private lateinit var categoryAdapter: CategoryAdapter

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

        /*Initialise Categories Adapter*/
        initCategoryAdapter()

        /*Bind Games Category Adapter*/
        binding.recyclerViewCategory.adapter = categoryAdapter

        fetchGameCategories()
        observeGameCategories()
        return binding.root
    }

    /*Function for Initialising Category Adapter*/
    private fun initCategoryAdapter() {
        categoryAdapter = CategoryAdapter()
    }

    /*Function for Fetching All The Categories From Repository*/
    private fun fetchGameCategories() {
        gamesViewModel.fetchAllCategories(requireContext())
    }

    /*Function for Populating The Games Categories In The View*/
    private fun observeGameCategories() {
        gamesViewModel.categories.observe(viewLifecycleOwner, {
            categoryAdapter.submitList(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}