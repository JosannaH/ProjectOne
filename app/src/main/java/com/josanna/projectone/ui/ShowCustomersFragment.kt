package com.josanna.projectone.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.josanna.projectone.R
import com.josanna.projectone.ShowCustomersAdapter
import com.josanna.projectone.database.MyDatabase
import com.josanna.projectone.databinding.FragmentShowCustomersBinding
import com.josanna.projectone.entities.Customer
import kotlinx.coroutines.runBlocking

class ShowCustomersFragment : Fragment(R.layout.fragment_show_customers) {

    private lateinit var binding: FragmentShowCustomersBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentShowCustomersBinding.bind(view)

        val db = MyDatabase.getInstance(requireContext())

        var customerList = listOf<Customer>()

        runBlocking {

            customerList = db.getCustomerDao().getAllCustomers()
            Log.d("ShowCustomerFragment", "customerList: $customerList")
        }

        val adapter = ShowCustomersAdapter(customerList)
        Log.d("ShowCustomerFragment", "customerList adapter: " + adapter.getItemCount())

        binding.rvShowAllCustomers.adapter = adapter

        binding.rvShowAllCustomers.layoutManager = LinearLayoutManager(requireActivity())
    }
}
