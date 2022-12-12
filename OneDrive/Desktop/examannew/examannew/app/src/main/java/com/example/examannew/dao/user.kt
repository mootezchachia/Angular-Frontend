package com.example.examannew.dao

import androidx.room.*
import com.example.examannew.data.User


@Dao
interface UserDao {
    @Insert
    fun insert(edc: User)

    @Update
    fun update(edc: User)

    @Delete
    fun delete(edc: User)

    @Query("SELECT * FROM user")
    fun getAllEducations(): MutableList<User>
}