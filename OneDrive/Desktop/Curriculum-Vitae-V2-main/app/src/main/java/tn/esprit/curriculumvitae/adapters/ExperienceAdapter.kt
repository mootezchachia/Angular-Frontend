package tn.esprit.curriculumvitae.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.curriculumvitae.R
import tn.esprit.curriculumvitae.data.Experience
import tn.esprit.curriculumvitae.utils.AppDataBase

class ExperienceAdapter (val experienceList: MutableList<Experience>) : RecyclerView.Adapter<ExperienceAdapter.ExperienceViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExperienceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.experience_single_row, parent, false)
        return ExperienceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {

        val exp = experienceList[position]

        holder.companyLogo.setImageURI(Uri.parse(exp.companyLogo))
        holder.companyName.text = exp.companyName
        holder.companyAddress.text = exp.companyAddress
        holder.startDate.text = exp.startDate
        holder.endDate.text = exp.endDate
        holder.companyDescription.text = exp.workDescription

        holder.btnDelete.setOnClickListener {

            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Delete Experience")
                .setMessage(holder.itemView.context.getString(R.string.deleteMessageComp, exp.companyName))
                .setPositiveButton("Yes"){ dialogInterface, which ->

                    AppDataBase.getDatabase(holder.itemView.context).experienceDao().delete(exp)
                    experienceList.removeAt(position)
                    notifyDataSetChanged()

                }.setNegativeButton("No"){dialogInterface, which ->
                    dialogInterface.dismiss()
                }.create().show()

        }

    }

    override fun getItemCount(): Int = experienceList.size

    class ExperienceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val companyLogo = itemView.findViewById<ImageView>(R.id.companyLogo)
        val companyName = itemView.findViewById<TextView>(R.id.companyName)
        val companyAddress = itemView.findViewById<TextView>(R.id.companyAddress)
        val startDate = itemView.findViewById<TextView>(R.id.startDate)
        val endDate = itemView.findViewById<TextView>(R.id.endDate)
        val companyDescription = itemView.findViewById<TextView>(R.id.workDescription)
        val btnDelete = itemView.findViewById<ImageView>(R.id.btnDelete)
    }
}