package com.cloffygames.gpacalculator.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cloffygames.gpacalculator.data.entity.Department
import com.cloffygames.gpacalculator.databinding.CardDepartmentBinding

class DepartmentAdapter(var dContext: Context, var departmentList : List<Department>) : RecyclerView.Adapter<DepartmentAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(var design : CardDepartmentBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding = CardDepartmentBinding.inflate(LayoutInflater.from(dContext), parent, false)

        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val department = departmentList.get(position)
        val d = holder.design

        d.departmentName.text = department.name
        d.GPAText.text = department.gpa.toString()
    }

    override fun getItemCount(): Int {

        return departmentList.size
    }

}