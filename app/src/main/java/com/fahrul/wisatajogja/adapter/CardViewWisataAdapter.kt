package com.fahrul.wisatajogja.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fahrul.wisatajogja.R
import com.fahrul.wisatajogja.model.Wisata
import com.fahrul.wisatajogja.ui.detailWisata

class CardViewWisataAdapter  (private val listWisata:ArrayList<Wisata>) : RecyclerView.Adapter<CardViewWisataAdapter.CardViewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_wisata, parent, false)
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listWisata.size
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val (name, detail, photo, address, time) = listWisata[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(150, 120))
            .into(holder.imgPhoto)
        holder.tvName.text = name
        holder.tvDetail.text = detail
        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, detailWisata::class.java)
            moveDetail.putExtra(detailWisata.EXTRA_NAME, name)
            moveDetail.putExtra(detailWisata.EXTRA_PHOTO, photo)
            moveDetail.putExtra(detailWisata.EXTRA_DETAIL, detail)
            moveDetail.putExtra(detailWisata.EXTRA_ADDRESS, address)
            moveDetail.putExtra(detailWisata.EXTRA_TIME, time)
            mContext.startActivity(moveDetail)
        }
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_wisata)
//        var tvAddress: TextView = itemView.findViewById(R.id.tv_item_address)
//        var tvTime: TextView = itemView.findViewById(R.id.tv_item_time)
    }

}