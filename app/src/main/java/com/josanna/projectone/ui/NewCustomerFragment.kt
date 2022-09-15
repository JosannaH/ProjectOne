package com.josanna.projectone.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import com.josanna.projectone.R
import com.josanna.projectone.database.MyDatabase
import com.josanna.projectone.databinding.FragmentNewCustomerBinding
import com.josanna.projectone.entities.Customer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class NewCustomerFragment : Fragment(R.layout.fragment_new_customer) {

    private lateinit var binding : FragmentNewCustomerBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNewCustomerBinding.bind(view)

        binding.btnSave.setOnClickListener {

            //val savedToDatabase =
            insertCustomerToDatabase()

            /*
            if(savedToDatabase){*/
            val message = getString(R.string.horse_is_saved)
            showToast(message)

            val fragmentMainMenu = MainMenuFragment()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, fragmentMainMenu)
                commit()
            }
        }
    }

    private fun insertCustomerToDatabase(){

        val firstName = binding.etFirstName.text.toString()//.trim()
        val lastName = binding.etLastName.text.toString()//.trim()
        val street = binding.etStreet.text.toString()//.trim()
        val postCode = binding.etPostCode.text.toString()//.trim()
        val city = binding.etCity.text.toString()//.trim()
        val phone = binding.etPhone.text.toString()//.trim()
        val email = binding.etEmail.text.toString()//.trim()
        //TODO: Make notes a text file?
        val notes = binding.etNotes.text.toString()



        val inputIsCorrect = inputCheck(firstName, lastName, street, postCode, city, phone)

        if(inputIsCorrect){

            val customer = Customer(0, firstName, lastName, street, postCode, city, phone, email, notes)
            Log.d("Customer object: ", customer.toString())

            GlobalScope.launch(Dispatchers.IO) {
                val db: MyDatabase = MyDatabase.getInstance(requireContext())
                db.getCustomerDao().upsertCustomer(customer)
                // TODO: check if the insertion was successful and return result as Boolean
            }
        }
    }

    private fun inputCheck(firstName: String, lastName: String, street: String, postCode: String, city: String,
    phone: String): Boolean{

        var inputCheck = true

        val message: String
        if(firstName.isEmpty()){
            message = getString(R.string.fill_in_firstName)
            showToast(message)
            inputCheck = false
        }
        else if(lastName.isEmpty()){
            message = getString(R.string.Fill_in_lastName)
            showToast(message)
            inputCheck = false
        }
        else if(street.isEmpty()){
            message = getString(R.string.fill_in_streetAddress)
            showToast(message)
            inputCheck = false
        }
        else if(postCode.isEmpty()){
            message = getString(R.string.fill_in_postCode)
            showToast(message)
            inputCheck = false
        }
        else if(city.isEmpty()){
            message = getString(R.string.fill_in_city)
            showToast(message)
            inputCheck = false
        }
        else if(phone.isEmpty() || !phone.isDigitsOnly()){
            message = getString(R.string.fill_in_phone)
            showToast(message)
            inputCheck = false
        }
        return inputCheck
    }

    private fun showToast(message: String){
        Toast.makeText(context, message, Toast.LENGTH_LONG)
    }

}