package com.josanna.projectone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.josanna.projectone.R
import com.josanna.projectone.databinding.FragmentNewHorseBinding
import com.josanna.projectone.entities.Horse

class NewHorseFragment : Fragment(R.layout.fragment_new_horse) {

    private lateinit var b : FragmentNewHorseBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b = FragmentNewHorseBinding.bind(view)

        b.btnSave.setOnClickListener {
            val name = b.etName
            val type = b.spAnimalType.toString()
            val gender = b.spGender.toString()
            val birthYear = b.etBirthYear
            val id = b.etIdNumber
            val notes = b.etNotes

            //TODO: Save to database
        }

    }
}