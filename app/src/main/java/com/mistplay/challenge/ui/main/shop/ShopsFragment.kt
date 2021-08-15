package com.mistplay.challenge.ui.main.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mistplay.challenge.databinding.FragmentShopsBinding

class ShopsFragment : Fragment() {

    private lateinit var shopsViewModel: ShopsViewModel
    private var _binding: FragmentShopsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shopsViewModel =
            ViewModelProvider(this).get(ShopsViewModel::class.java)

        _binding = FragmentShopsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textShops
        shopsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}