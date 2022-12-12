package com.example.examannew.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.examannew.R
import com.example.examannew.data.Cars
import com.example.examannew.utils.AppDataBase

import com.example.examanold.viewholder.ChampionViewHolder
import com.google.android.material.snackbar.Snackbar


class ChampionAdapter(val championsList: MutableList<Cars>) : RecyclerView.Adapter<ChampionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemquestion, parent, false)

        return ChampionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChampionViewHolder, position: Int) {
        val Title = championsList[position].title
        val description = championsList[position].description
        val participation = championsList[position].participation


        lateinit var educationList : MutableList<Cars>
        lateinit var dataBase: AppDataBase

        holder.championName.text = Title
        holder.championdescription.text = description

        dataBase = AppDataBase.getDatabase(holder.itemView.context)

        educationList = dataBase.carsdao().getAllEducations()

        for (name in educationList) {

        }
        holder.itemView.setOnClickListener {

            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Participation")
                .setMessage("You want participate in this event ?")
                .setPositiveButton("Yes"){ dialogInterface, which ->
                    var test = 0
                    for (name in educationList){
                        if(name.title == Title){
                            val snackbar1 =
                                Snackbar.make(holder.itemView, "Already aded", Snackbar.LENGTH_SHORT)
                            snackbar1.show()
                            dialogInterface.dismiss()
                             test = 1
                        }

                    }
                    if (test==0){
                        AppDataBase.getDatabase(holder.itemView.context).carsdao().insert(
                            Cars(0, title = Title, description = description, participation = "true")
                        )
                        notifyDataSetChanged()
                    }

                }.setNegativeButton("No"){dialogInterface, which ->
                    dialogInterface.dismiss()
                }.create().show()

        }


    }

    override fun getItemCount() = championsList.size
}