package com.cloffygames.gpacalculator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloffygames.gpacalculator.R
import com.cloffygames.gpacalculator.databinding.FragmentAddDepartmentBinding

class AddDepartmentFragment : Fragment() {
    private lateinit var binding: FragmentAddDepartmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentAddDepartmentBinding.inflate(inflater, container, false)

        return binding.root
    }

}