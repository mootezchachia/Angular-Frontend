package com.example.examannew.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cars")
data class Cars (
    @PrimaryKey(autoGenerate = true)
    val id: Int,


    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "participation")
    val participation: String,


    )