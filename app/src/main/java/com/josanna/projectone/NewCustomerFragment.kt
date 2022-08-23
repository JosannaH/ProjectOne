package com.josanna.projectone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.josanna.projectone.databinding.FragmentNewCustomerBinding
import com.josanna.projectone.databinding.FragmentNewHorseBinding

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

            //TODO: Save to database
        }

    }
}