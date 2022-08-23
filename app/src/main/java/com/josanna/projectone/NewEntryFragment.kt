package com.josanna.projectone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.josanna.projectone.databinding.FragmentNewEntryBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NewEntryFragment : Fragment(R.layout.fragment_new_entry) {

    private lateinit var b : FragmentNewEntryBinding



    @SuppressLint("NewApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        b = FragmentNewEntryBinding.bind(view)

        val currentTime = LocalDateTime.now()
        val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val timeFormat = DateTimeFormatter.ofPattern("HH:mm")
        val formattedDate = currentTime.format(dateFormat)
        val formattedTime = currentTime.format(timeFormat)

        b.etDate.setText(formattedDate)
        b.etTime.setText(formattedTime)


  

    }
}