package com.josanna.projectone.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.josanna.projectone.R
import com.josanna.projectone.ShowHorsesAdapter
import com.josanna.projectone.database.MyDatabase
import com.josanna.projectone.databinding.FragmentNewHorseBinding
import com.josanna.projectone.databinding.FragmentShowHorsesBinding
import com.josanna.projectone.entities.Horse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ShowHorsesFragment : Fragment(R.layout.fragment_show_horses) {

    private lateinit var b: FragmentShowHorsesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        b = FragmentShowHorsesBinding.bind(view)

        val db = MyDatabase.getInstance(requireContext())
        var horseList = listOf<Horse>()

        runBlocking {

            horseList = db.getHorseDao().getAllHorses()
            Log.d("ShowHorseFragment", "horseList: $horseList")
        }

        val adapter = ShowHorsesAdapter(horseList)
        Log.d("ShowHorseFragment", "horseList adapter: " + adapter.getItemCount())

        b.rvShowAllHorses.adapter = adapter

        b.rvShowAllHorses.layoutManager = LinearLayoutManager(requireActivity())
    }
}
