package com.example.examannew.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.examannew.R
import com.example.examannew.data.Cars
import com.example.examannew.utils.AppDataBase


import com.example.examanold.viewholder.ChampionViewHolderdelete


class ChampionAdapterdelet(val championsList: MutableList<Cars>) : RecyclerView.Adapter<ChampionViewHolderdelete>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionViewHolderdelete {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycleitem, parent, false)

        return ChampionViewHolderdelete(view)
    }

    override fun onBindViewHolder(holder: ChampionViewHolderdelete, position: Int) {
        val Title = championsList[position].title
        val description = championsList[position].description
        val participation = championsList[position].participation


        val edc = championsList[position]



        holder.championName.text = Title
        holder.championdescription.text = description
        holder.itemView.setOnClickListener {

            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Participation")
                .setMessage("You want to unparticipate in this event?")
                .setPositiveButton("Yes"){ dialogInterface, which ->
                    AppDataBase.getDatabase(holder.itemView.context).carsdao().delete(edc)
                    championsList.removeAt(position)
                    notifyDataSetChanged()


                }.setNegativeButton("No"){dialogInterface, which ->
                    dialogInterface.dismiss()
                }.create().show()

        }


    }

    override fun getItemCount() = championsList.size
}