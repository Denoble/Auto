package com.gevcorst.carfaxproject2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.gevcorst.carfaxproject2.R
import com.gevcorst.carfaxproject2.databinding.FragmentCarDetailsBinding
import com.gevcorst.carfaxproject2.databinding.FragmentCarListBinding
import com.gevcorst.carfaxproject2.viewmodels.CarListViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CarDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    var _binding: FragmentCarDetailsBinding? = null
    val binding get() = _binding!!
    val viewModel: CarListViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCarDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }
}