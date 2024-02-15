package com.cloffygames.gpacalculator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.cloffygames.gpacalculator.MainActivity
import com.cloffygames.gpacalculator.R
import com.cloffygames.gpacalculator.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.addDepartmentButton.setOnClickListener{
            val transfer = MainFragmentDirections.actionMainFragmentToAddDepartmentFragment()
            Navigation.findNavController(it).navigate(transfer)
        }

        binding.fastCalculateButton.setOnClickListener{
            val transfer = MainFragmentDirections.actionMainFragmentToSemesterFragment()
            Navigation.findNavController(it).navigate(transfer)
        }


        return binding.root
    }

}