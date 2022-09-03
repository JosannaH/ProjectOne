package com.josanna.projectone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.josanna.projectone.R
import com.josanna.projectone.databinding.FragmentNewCustomerBinding

class NewCustomerFragment : Fragment(R.layout.fragment_new_customer) {

    private lateinit var b : FragmentNewCustomerBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b = FragmentNewCustomerBinding.bind(view)

        b.btnSave.setOnClickListener {
            val firstName = b.etFirstName
            val lastName = b.etLastName
            val street = b.etStreet
            val postCode = b.etPostCode
            val city = b.etCity
            val phone = b.etPhone.toString()
            val email = b.etEmail.toString()
            val notes = b.etNotes

            //TODO: Save to database
        }

    }
}