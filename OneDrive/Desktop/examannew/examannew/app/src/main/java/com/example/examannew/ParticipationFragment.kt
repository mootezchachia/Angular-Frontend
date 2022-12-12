package com.example.examannew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examannew.adapter.ChampionAdapterdelet
import com.example.examannew.data.Cars
import com.example.examannew.utils.AppDataBase

class ParticipationFragment : Fragment() {

    lateinit var educationRecyclerView: RecyclerView
    lateinit var educationAdapter: ChampionAdapterdelet

    lateinit var educationList : MutableList<Cars>

    lateinit var dataBase: AppDataBase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_participation, container, false)

        dataBase = AppDataBase.getDatabase(requireActivity())

        educationRecyclerView = rootView.findViewById(R.id.favoriterecycle)

        educationList = dataBase.carsdao().getAllEducations()

        educationAdapter = ChampionAdapterdelet(educationList)

        educationRecyclerView.adapter = educationAdapter

        educationRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false)

        return rootView
    }


}