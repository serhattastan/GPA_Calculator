package com.cloffygames.gpacalculator.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloffygames.gpacalculator.R
import com.cloffygames.gpacalculator.databinding.FragmentSemesterBinding
import com.cloffygames.gpacalculator.ui.adapter.SemesterAdapter

class SemesterFragment : Fragment() {
    private lateinit var binding: FragmentSemesterBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentSemesterBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val semesterAdapter = SemesterAdapter(requireContext(), binding.spinner.count)
        binding.recyclerView.adapter = semesterAdapter

        // Bir ArrayAdapter oluşturur ve kaynak olarak bir string-array verir
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.semester_array,
            R.layout.spinner_item
        )
        // Spinner'ın açılır menüsü için bir düzen belirler
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        // Spinner'a adapter'ı uygular
        binding.spinner.adapter = adapter

        // Spinner'dan seçilen değeri tutmak için bir değişken tanımlar
        var selectedSemester = "0"
        // Spinner'a bir seçim dinleyicisi atar
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Adapter'dan seçilen değeri alır ve değişkene atar
                selectedSemester = adapter.getItem(position).toString()
                val semesterAdapter = SemesterAdapter(requireContext(), selectedSemester.toInt())
                binding.recyclerView.adapter = semesterAdapter
            }
            // Spinner'da hiçbir seçim yapılmadığında bu metod çalışır
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Hiçbir şey yapmaz
            }
        }

        return binding.root
    }

}