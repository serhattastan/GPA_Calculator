package com.cloffygames.gpacalculator.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.cloffygames.gpacalculator.R
import com.cloffygames.gpacalculator.databinding.FragmentAddDepartmentBinding

class AddDepartmentFragment : Fragment() {
    private lateinit var binding: FragmentAddDepartmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentAddDepartmentBinding.inflate(inflater, container, false)

        // Bir ArrayAdapter oluşturur ve kaynak olarak bir string-array verir
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.semester_array,
            R.layout.spinner_item
        )

        // Spinner'ın açılır menüsü için bir düzen belirler
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
        // Spinner'a adapter'ı uygular
        binding.spinner.adapter = adapter

        // Spinner'dan seçilen değeri tutmak için bir değişken tanımlar
        var selectedSemester = "0"
        // Spinner'a bir seçim dinleyicisi atar
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Adapter'dan seçilen değeri alır ve değişkene atar
                selectedSemester = adapter.getItem(position).toString()
            }

            // Spinner'da hiçbir seçim yapılmadığında bu metod çalışır
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Hiçbir şey yapmaz
            }
        }

        return binding.root
    }

}