package com.cloffygames.gpacalculator.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cloffygames.gpacalculator.R
import com.cloffygames.gpacalculator.databinding.ItemSemesterBinding

class SemesterAdapter(var sContext: Context, var lessonCount : Int) : RecyclerView.Adapter<SemesterAdapter.ItemDesignHolder>() {

    inner class ItemDesignHolder(var item : ItemSemesterBinding) : RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDesignHolder {
        val binding = ItemSemesterBinding.inflate(LayoutInflater.from(sContext), parent, false)

        return ItemDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemDesignHolder, position: Int) {
        val binding = holder.item

        // Bir ArrayAdapter oluşturur ve kaynak olarak bir string-array verir
        val adapter = ArrayAdapter.createFromResource(
            sContext,
            R.array.semester_array,
            R.layout.spinner_item
        )
        // Spinner'ın açılır menüsü için bir düzen belirler
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        // Spinner'a adapter'ı uygular
        binding.spinnerCredit.adapter = adapter
        binding.spinnerScore.adapter = adapter

        // Spinner'dan seçilen değeri tutmak için bir değişken tanımlar
        var selectedCredit = "0"
        var selectedScore = "0"

        binding.spinnerCredit.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Adapter'dan seçilen değeri alır ve değişkene atar
                selectedCredit = adapter.getItem(position).toString()
            }
            // Spinner'da hiçbir seçim yapılmadığında bu metod çalışır
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Hiçbir şey yapmaz
            }
        }
        // Spinner'a bir seçim dinleyicisi atar
        binding.spinnerScore.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Adapter'dan seçilen değeri alır ve değişkene atar
                selectedCredit = adapter.getItem(position).toString()
            }
            // Spinner'da hiçbir seçim yapılmadığında bu metod çalışır
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Hiçbir şey yapmaz
            }
        }
    }

    override fun getItemCount(): Int {

        return lessonCount
    }


}