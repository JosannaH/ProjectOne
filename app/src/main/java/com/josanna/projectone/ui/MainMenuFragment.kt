package com.josanna.projectone.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.josanna.projectone.R
import com.josanna.projectone.databinding.FragmentMainMenuBinding

class MainMenuFragment : Fragment(R.layout.fragment_main_menu) {

    private lateinit var binding : FragmentMainMenuBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainMenuBinding.bind(view)

        binding.btnNewHorse.setOnClickListener {
             val fragmentNewHorse = NewHorseFragment()

              requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment,fragmentNewHorse)
                addToBackStack(null)
                commit()
            }
        }

        binding.btnNewCustomer.setOnClickListener {
            val fragmentNewCustomer = NewCustomerFragment()

            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, fragmentNewCustomer)
                addToBackStack(null)
                commit()
            }
        }

        binding.btnNewEntry.setOnClickListener {
            val fragmentNewEntry = NewEntryFragment()

            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, fragmentNewEntry)
                addToBackStack(null)
                commit()
            }
        }

        binding.btnShowHorses.setOnClickListener {
            val fragmentShowHorses = ShowHorsesFragment()

            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, fragmentShowHorses)
                addToBackStack(null)
                commit()
            }
        }

        binding.btnShowCustomers.setOnClickListener {
            val fragmentShowCustomers = ShowCustomersFragment()

            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, fragmentShowCustomers)
                addToBackStack(null)
                commit()
            }
        }
    }
}