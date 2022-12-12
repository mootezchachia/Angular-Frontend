package tn.esprit.curriculumvitae.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.curriculumvitae.R
import tn.esprit.curriculumvitae.adapters.EducationAdapter
import tn.esprit.curriculumvitae.data.Education
import tn.esprit.curriculumvitae.utils.AppDataBase

class EducationFragment : Fragment() {

    lateinit var educationRecyclerView: RecyclerView
    lateinit var educationAdapter: EducationAdapter

    lateinit var educationList : MutableList<Education>

    lateinit var dataBase: AppDataBase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_education, container, false)

        dataBase = AppDataBase.getDatabase(requireActivity())

        educationRecyclerView = rootView.findViewById(R.id.recyclerEducation)

        educationList = dataBase.educationDao().getAllEducations()

        educationAdapter = EducationAdapter(educationList)

        educationRecyclerView.adapter = educationAdapter

        educationRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false)

        return rootView
    }

}