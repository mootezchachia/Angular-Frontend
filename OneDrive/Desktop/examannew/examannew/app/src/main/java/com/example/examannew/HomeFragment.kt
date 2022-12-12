package com.example.examannew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examannew.adapter.ChampionAdapter
import com.example.examannew.data.Cars

class HomeFragment : Fragment() {
    lateinit var recylcerChampion: RecyclerView
    lateinit var recylcerChampionAdapter: ChampionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)



        recylcerChampion = rootView.findViewById(R.id.recyclerChampion)

        var champList : MutableList<Cars> = ArrayList()
        champList.add(Cars(0, title =  "Game Day GD3", description = "Demain 20 Mai à partir de 9H au Bloc G, venez découvrir les jeux développés par nos étudiants de 1ère année durant l\\'évènement GD3 (Game Design et Development Day) !!!", participation = "false" ))

        champList.add(Cars(0, title =   " Bal des Projets", description = "Ne ratez pas le rendez-vous annuel de l\\'événement phare d\\'Esprit  le #baldesprojets dans sa 9ème édition, demain, 03 Juin 2022, à partir de 9h au Bloc L, Esprit El Ghazela.", participation = "false" ))
        champList.add(Cars(0, title =   " Forum Entreprise", description = "Nous avons l\\'immense plaisir de vous inviter au Forum des Entreprises organisé par le Groupe ESPRIT (Esprit School of Business et Esprit School of Engineering) qui se tiendra à notre Campus à El Ghazala (Bâtiment G) le vendredi 10 Juin 2022 de 8H30 à 14h", participation = "false" ))

        recylcerChampionAdapter = ChampionAdapter(champList)
        recylcerChampion.adapter = recylcerChampionAdapter
        recylcerChampion.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false)


        return rootView  }


}