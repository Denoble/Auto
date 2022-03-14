package com.gevcorst.carfaxproject2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import com.gevcorst.carfaxproject2.R
import com.gevcorst.carfaxproject2.databinding.FragmentCarDetailsBinding
import com.gevcorst.carfaxproject2.databinding.FragmentCarListBinding
import com.gevcorst.carfaxproject2.model.Listings
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listings = CarDetailsFragmentArgs.fromBundle(requireArguments()).selectedListing
       val title =   listings.year.toString()+" "+listings.make+" "+listings.model
        loadImage(binding.imageViewDetailsLayout,listings.images.firstPhoto.large)
        populateListingsData(listings)

        (requireActivity() as MainActivity).supportActionBar?.title = title
    }
    fun loadImage(imageView: ImageView,url:String){
        bindImage(imageView,url)
    }
    fun populateListingsData(listings:Listings){
        binding.detailLayoutTvYear.text = listings.year.toString()
        binding.detailsLayoutTvMake.text = listings.make
        binding.detailsLayoutTvModel.text = listings.model
        binding.detailsLayoutTvTrim.text = listings.trim
        binding.detailsLayoutTvPrice.text =(requireContext().getString(R.string.dollar_sign)+
                listings.currentPrice.toString())
        binding.detailsLayoutTvMillage.text =
            listings.mileage.toString()+requireContext().getString(R.string.mileage_symbol)
        val location = listings.dealer.city+" "+ listings.dealer.state
        binding.detailsLayoutExtension.detailsLayoutTvLocation.text =location
        binding.detailsLayoutExtension.detailsLayoutTvExteriorColor.text =
            listings.exteriorColor
        binding.detailsLayoutExtension.detailsLayoutInterioColor.text =
            listings.interiorColor
        binding.detailsLayoutExtension.detailsLayoutDriveType.text =
            listings.drivetype
        binding.detailsLayoutExtension.detailsLayoutTvTransmission.text =
            listings.transmission
        binding.detailsLayoutExtension.detailsLayoutTvBody.text = listings.bodytype
        binding.detailsLayoutExtension.detailsLayoutTvEngine.text = listings.engine
        binding.detailsLayoutExtension.detailsLayoutTvFuel.text = listings.fuel



    }
}