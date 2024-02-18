package com.cloffygames.gpacalculator.data.entity

//@Entity(tableName = "courses")
data class Department(
//    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val gpa : Double,
)