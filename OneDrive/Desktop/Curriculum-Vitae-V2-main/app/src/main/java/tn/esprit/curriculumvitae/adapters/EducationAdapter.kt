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
import tn.esprit.curriculumvitae.data.Education
import tn.esprit.curriculumvitae.utils.AppDataBase

class EducationAdapter(val educationList: MutableList<Education>) : RecyclerView.Adapter<EducationAdapter.EducationViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EducationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.education_single_row, parent, false)
        return EducationViewHolder(view)
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        val edc = educationList[position]

        holder.companyLogo.setImageURI(Uri.parse(edc.universityLogo))
        holder.companyName.text = edc.universityName
        holder.companyAddress.text = edc.universityAddress
        holder.startDate.text = edc.startDate
        holder.endDate.text = edc.endDate

        holder.btnDelete.setOnClickListener {

            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Delete Education")
                .setMessage(holder.itemView.context.getString(R.string.deleteMessageUniv, edc.universityName))
                .setPositiveButton("Yes"){ dialogInterface, which ->
                    AppDataBase.getDatabase(holder.itemView.context).educationDao().delete(edc)
                    educationList.removeAt(position)
                    notifyDataSetChanged()

            }.setNegativeButton("No"){dialogInterface, which ->
                dialogInterface.dismiss()
            }.create().show()

        }

    }

    override fun getItemCount(): Int = educationList.size

    class EducationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val companyLogo = itemView.findViewById<ImageView>(R.id.companyLogo)
        val companyName = itemView.findViewById<TextView>(R.id.companyName)
        val companyAddress = itemView.findViewById<TextView>(R.id.companyAddress)
        val startDate = itemView.findViewById<TextView>(R.id.startDate)
        val endDate = itemView.findViewById<TextView>(R.id.endDate)

        val btnDelete = itemView.findViewById<ImageView>(R.id.btnDelete)

    }
}