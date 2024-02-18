package com.cloffygames.gpacalculator.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloffygames.gpacalculator.R
import com.cloffygames.gpacalculator.databinding.FragmentDepartmentBinding

class DepartmentFragment : Fragment() {
    private lateinit var binding: FragmentDepartmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentDepartmentBinding.inflate(inflater, container, false)

        return binding.root
    }

}