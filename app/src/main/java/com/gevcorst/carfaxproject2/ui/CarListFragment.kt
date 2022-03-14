package com.gevcorst.carfaxproject2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.gevcorst.carfaxproject2.databinding.FragmentCarListBinding
import com.gevcorst.carfaxproject2.model.Listings
import com.gevcorst.carfaxproject2.viewmodels.CarListViewModel
import com.gevcorst.carfaxproject2.viewmodels.ServiceStatus
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CarListFragment : Fragment() {
    var _binding: FragmentCarListBinding? = null
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
        _binding = FragmentCarListBinding.inflate(inflater, container, false)
        viewModel.updateList(requireContext())
        observerListingList()
        return binding.root
    }

    private fun observerListingList() {
        viewModel.carListings.observe(viewLifecycleOwner, Observer { listingList ->
            if(listingList.size > 0){
                binding.imageViewFragmentCarListLoading.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
                binding.recyclerView.adapter =
                    ListAdapter(listingList, this.requireActivity(),ListAdapter.OnClickListener {listings ->
                        findNavController().navigate(
                            CarListFragmentDirections
                                .actionCarListFragmentToCarDetailsFragment(listings)
                        )
                    })
            }
        })
    }
}