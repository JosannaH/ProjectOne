package com.josanna.projectone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import com.josanna.projectone.R
import com.josanna.projectone.databinding.FragmentNewHorseBinding
import com.josanna.projectone.entities.Horse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewHorseFragment : Fragment(R.layout.fragment_new_horse) {

    private lateinit var b : FragmentNewHorseBinding
    private var saveToDatabase = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b = FragmentNewHorseBinding.bind(view)

        b.btnSave.setOnClickListener {

            saveToDatabase = insertHorseToDatabase()

            if(saveToDatabase){
                // TODO: what to do when horse is saved
            }
            else{
                // TODO: if saving is unsuccessful
            }
        }
    }

    private fun insertHorseToDatabase(): Boolean{

        val name = b.etName.text.toString()
        val type = b.spAnimalType.selectedItem.toString()
        val gender = b.spGender.selectedItem.toString()
        val birthYear = b.etBirthYear.text.toString()
        val identification = b.etIdentification.text.toString()
        val notes = b.etNotes.text.toString()

        val result: Boolean = false
        val inputIsCorrect: Boolean
        // val dao: HorseDao

        inputIsCorrect = inputCheck(name, birthYear, identification)

        if(inputIsCorrect){

            val horse = Horse(0, name, type, gender, birthYear,
                identification, notes, 0)  // TODO: pass a real customer id

            GlobalScope.launch(Dispatchers.IO) {
                //TODO: upsert horse!!
            }
        }
        // if input is not correct - do nothing

        return result // is the insertion successful or not
    }

    private fun inputCheck(name: String, birthYear: String, identification: String): Boolean{
        var inputCheck = true
        val message: String
        if(name.isEmpty()){
            message = getString(R.string.fill_in_name)
            showErrorToast(message)
            inputCheck = false
        }
        else if(birthYear.isEmpty() || !birthYear.isDigitsOnly()){
            message = getString(R.string.Fill_in_birth_year)
            showErrorToast(message)
            inputCheck = false
        }
        else if(identification.isEmpty()){
            message = getString(R.string.fill_in_identification)
            showErrorToast(message)
            inputCheck = false
        }
        return inputCheck
    }

    private fun showErrorToast(message: String){
        Toast.makeText(context, message, Toast.LENGTH_LONG)
    }
}