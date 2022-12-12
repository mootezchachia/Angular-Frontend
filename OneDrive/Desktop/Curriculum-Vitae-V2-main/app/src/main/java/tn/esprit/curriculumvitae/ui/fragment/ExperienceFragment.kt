package tn.esprit.curriculumvitae.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tn.esprit.curriculumvitae.R
import tn.esprit.curriculumvitae.adapters.ExperienceAdapter
import tn.esprit.curriculumvitae.data.Experience
import tn.esprit.curriculumvitae.utils.AppDataBase


class ExperienceFragment : Fragment() {

    lateinit var experienceRecyclerView: RecyclerView
    lateinit var experienceAdapter: ExperienceAdapter

    lateinit var experienceList : MutableList<Experience>

    lateinit var dataBase: AppDataBase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_experience, container, false)

        dataBase = AppDataBase.getDatabase(requireActivity())

        experienceRecyclerView = rootView.findViewById(R.id.recyclerExperience)

        experienceList = dataBase.experienceDao().getAllExperiences()

        experienceAdapter = ExperienceAdapter(experienceList)

        experienceRecyclerView.adapter = experienceAdapter

        experienceRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,
            false)

        return rootView
    }

}