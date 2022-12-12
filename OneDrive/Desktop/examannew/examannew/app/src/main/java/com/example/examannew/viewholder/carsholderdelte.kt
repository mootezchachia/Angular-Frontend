package com.example.examanold.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examannew.R


class ChampionViewHolderdelete(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val championName : TextView
    val championdescription : TextView



    init {

        championName = itemView.findViewById<TextView>(R.id.Subject)
        championdescription = itemView.findViewById<TextView>(R.id.Description)

    }
}