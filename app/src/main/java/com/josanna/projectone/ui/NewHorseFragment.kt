package com.josanna.projectone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import com.josanna.projectone.R
import com.josanna.projectone.database.MyDatabase
import com.josanna.projectone.databinding.FragmentNewHorseBinding
import com.josanna.projectone.entities.Horse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewHorseFragment : Fragment(R.layout.fragment_new_horse) {

    private lateinit var b : FragmentNewHorseBinding
    //private var savedToDatabase = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b = FragmentNewHorseBinding.bind(view)

        b.btnSave.setOnClickListener {

            //savedToDatabase =
            insertHorseToDatabase()

            /*
            if(savedToDatabase){*/
            val message = getString(R.string.horse_is_saved)
            showToast(message)

            val fragmentMainMenu = MainMenuFragment()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, fragmentMainMenu)
                commit()
            }
            // TODO: show choice to go to menu or to make an journal entry

            /*}
            else{
                // TODO: if saving is unsuccessful
            }*/
        }
    }

    private fun insertHorseToDatabase(){

        val name = b.etName.text.toString()
        val type = b.spAnimalType.selectedItem.toString()
        val gender = b.spGender.selectedItem.toString()
        val birthYear = b.etBirthYear.text.toString()
        val identification = b.etIdentification.text.toString()
        //TODO: Make notes a text file?
        val notes = b.etNotes.text.toString()

        val inputIsCorrect = inputCheck(name, birthYear, identification)

        if(inputIsCorrect){

            val horse = Horse(0, name, type, gender, birthYear,
                identification, notes, 0)  // TODO: pass a real customer id

            GlobalScope.launch(Dispatchers.IO) {
                val db: MyDatabase = MyDatabase.getInstance(requireContext())
                db.getHorseDao().upsertHorse(horse)
                // TODO: check if the insertion was successful and return result as Boolean
            }
        }
    }

    private fun inputCheck(name: String, birthYear: String, identification: String): Boolean{

        // TODO: change toast to textviews under edittexts

        var inputCheck = true
        val message: String
        if(name.isEmpty()){
            message = getString(R.string.fill_in_name)
            showToast(message)
            inputCheck = false
        }
        else if(birthYear.isEmpty() || !birthYear.isDigitsOnly()){
            message = getString(R.string.Fill_in_birth_year)
            showToast(message)
            inputCheck = false
        }
        else if(identification.isEmpty()){
            message = getString(R.string.fill_in_identification)
            showToast(message)
            inputCheck = false
        }
        return inputCheck
    }

    private fun showToast(message: String){
        Toast.makeText(context, message, Toast.LENGTH_LONG)
    }
}