package com.cloffygames.gpacalculator.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import com.cloffygames.gpacalculator.MainActivity
import com.cloffygames.gpacalculator.R
import com.cloffygames.gpacalculator.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        // binding.addDepartmentButton tıklandığında bir işlem yapmak için bir tıklama dinleyicisi eklenir.
        binding.addDepartmentButton.setOnClickListener{
            // Ana fragmentten Departman Ekleme fragmentine geçişi sağlayan bir action oluşturulur.
            val transfer = MainFragmentDirections.actionMainFragmentToAddDepartmentFragment()
            // Oluşturulan action kullanılarak fragment geçişi gerçekleştirilir.
            Navigation.findNavController(it).navigate(transfer)
        }

        // binding.fastCalculateButton tıklandığında bir işlem yapmak için bir tıklama dinleyicisi eklenir.
        binding.fastCalculateButton.setOnClickListener{
            // Ana fragmentten Dönem fragmentine geçişi sağlayan bir action oluşturulur.
            val transfer = MainFragmentDirections.actionMainFragmentToSemesterFragment()
            // Oluşturulan action kullanılarak fragment geçişi gerçekleştirilir.
            Navigation.findNavController(it).navigate(transfer)
        }

        // binding.departmentCard tıklandığında bir işlem yapmak için bir tıklama dinleyicisi eklenir.
        binding.departmentCard.setOnClickListener{
            // Ana fragmentten Departman fragmentine geçişi sağlayan bir action oluşturulur.
            val transfer = MainFragmentDirections.actionMainFragmentToDepartmentFragment()
            // Oluşturulan action kullanılarak fragment geçişi gerçekleştirilir.
            Navigation.findNavController(it).navigate(transfer)
        }

        binding.departmentDeleteButton.setOnClickListener{

        }

        // binding.searchView üzerinde arama yapıldığında bu metot çağrılır.
        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            // Yeni metin girildiğinde çağrılır.
            override fun onQueryTextChange(newText: String): Boolean {
                // Yeni metinle birlikte departman araması yapılır.
                searchDepartment(newText)
                return true
            }
            // Arama butonuna tıklandığında çağrılır.
            override fun onQueryTextSubmit(query: String): Boolean {
                // Girilen sorguyla birlikte departman araması yapılır.
                searchDepartment(query)
                return true
            }
        })

        return binding.root
    }

    // Verilen arama sorgusunu kullanarak departman araması yapar.
    fun searchDepartment(searchQuery : String){
        // Logcat'e arama sorgusu yazdırılır.
        Log.e("Kişi ara", searchQuery)
    }

}