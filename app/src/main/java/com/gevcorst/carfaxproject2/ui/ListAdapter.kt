package com.gevcorst.carfaxproject2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gevcorst.carfaxproject2.R
import com.gevcorst.carfaxproject2.model.Listings

class ListAdapter(
    private val list:List<Listings>,
    val onClickListener: ListAdapter.OnClickListener
) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ListViewHolder(inflatedView)

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val listing = list[position]
            holder.itemView.setOnClickListener {
            onClickListener.onClick(listing)
        }
        holder.bind(listing)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ListViewHolder(v: View) :
        RecyclerView.ViewHolder(v) {
        private val view: View = v
        val imageView: ImageView = view.findViewById(R.id.imageView_list_item)
        val year: TextView = view.findViewById(R.id.tv_year)
        val make: TextView = view.findViewById(R.id.tv_make)
        val model:TextView = view.findViewById(R.id.tv_model)
        val trim:TextView = view.findViewById(R.id.tv_trim)
        val price:TextView = view.findViewById(R.id.tv_price)
        val milleage:TextView = view.findViewById(R.id.tv_milleage)
        val location:TextView = view.findViewById(R.id.tv_location)
        fun bind(listing:Listings) {
            bindImage(imageView, listing.images.firstPhoto.medium)
            year.text = listing.year.toString()
            make.text = listing.make
            model.text = listing.model
            trim.text = listing.trim
            price.text = " $"+listing.currentPrice.toString()
            milleage.text = listing.mileage.toString() + " mi"
            val locationText =   listing.dealer.city + " " + listing.dealer.state
            location.text = locationText
        }

    }
    class OnClickListener(val clickListener: (listing:Listings) -> Unit) {
        fun onClick(curentListing: Listings) = clickListener(curentListing)
    }

}
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val glideImgUrl = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(glideImgUrl).apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_baseline_broken_image_24)
            )
            .into(imgView)
    }
}
