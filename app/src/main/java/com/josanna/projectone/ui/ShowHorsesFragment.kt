package com.josanna.projectone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.josanna.projectone.R
import com.josanna.projectone.ShowHorsesAdapter
import com.josanna.projectone.databinding.FragmentNewHorseBinding
import com.josanna.projectone.databinding.FragmentShowHorsesBinding
import com.josanna.projectone.entities.Horse

class ShowHorsesFragment : Fragment(R.layout.fragment_show_horses) {

    private lateinit var b : FragmentShowHorsesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        b = FragmentShowHorsesBinding.bind(view)

        //TODO fill list with horses from db
        var horseList = mutableListOf<Horse>()


        //test
        val testHorse1 = Horse(1, "Lotta", "Horse", "Mare", "2016", "652587458", "kobent", 2 )
        val testHorse2 = Horse(2, "Stjerna", "Horse", "Mare", "2014", "652578558", "Mamma till tre", 1 )
        horseList.add(testHorse1)
        horseList.add(testHorse2)
        //test end

        val adapter = ShowHorsesAdapter(horseList)

        b.rvShowAllHorses.adapter = adapter


        // TODO is it correct to use requireActivity() as context?
        b.rvShowAllHorses.layoutManager = LinearLayoutManager(requireActivity())

        }
    }
