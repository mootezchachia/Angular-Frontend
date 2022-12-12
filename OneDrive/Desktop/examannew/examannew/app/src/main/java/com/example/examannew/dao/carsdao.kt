package com.example.examannew.dao

import androidx.room.*
import com.example.examannew.data.Cars


@Dao
interface CarsDao {
    @Insert
    fun insert(edc: Cars)

    @Update
    fun update(edc: Cars)

    @Delete
    fun delete(edc: Cars)

    @Query("SELECT * FROM cars")
    fun getAllEducations(): MutableList<Cars>
}