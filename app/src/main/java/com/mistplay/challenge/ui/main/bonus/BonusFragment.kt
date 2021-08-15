package com.mistplay.challenge.ui.main.bonus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mistplay.challenge.databinding.FragmentBonusBinding

class BonusFragment : Fragment() {
    private lateinit var bonusViewModel: BonusViewModel
    private var _binding: FragmentBonusBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bonusViewModel =
            ViewModelProvider(this).get(BonusViewModel::class.java)

        _binding = FragmentBonusBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textBonus
        bonusViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}