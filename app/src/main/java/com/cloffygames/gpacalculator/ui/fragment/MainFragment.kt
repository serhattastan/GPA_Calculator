package com.cloffygames.gpacalculator.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloffygames.gpacalculator.data.entity.Department
import com.cloffygames.gpacalculator.databinding.FragmentMainBinding
import com.cloffygames.gpacalculator.ui.adapter.DepartmentAdapter

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.departmentsView.layoutManager = LinearLayoutManager(requireContext())
        val departmentList = ArrayList<Department>()
        val d1 = Department(1,"Bilgisayar Mühendisliği", 2.85)
        val d2 = Department(1,"Makine Mühendisliği", 2.35)
        val d3 = Department(1,"Elektronik Mühendisliği", 3.85)
        val d4 = Department(1,"Endüstri Mühendisliği", 2.65)
        val d5 = Department(1,"Mekatronik Mühendisliği", 1.85)
        val d6 = Department(1,"Orman Mühendisliği", 4.00)
        departmentList.add(d1)
        departmentList.add(d2)
        departmentList.add(d3)
        departmentList.add(d4)
        departmentList.add(d5)
        departmentList.add(d6)

        val departmentAdapter = DepartmentAdapter(requireContext(), departmentList)
        binding.departmentsView.adapter = departmentAdapter

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