package com.example.examannew.utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.examannew.dao.CarsDao
import com.example.examannew.dao.UserDao
import com.example.examannew.data.Cars
import com.example.examannew.data.User


@Database(entities = [Cars::class,User::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun carsdao(): CarsDao
    abstract fun userdao(): UserDao
    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            if (instance == null) {
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(context, AppDataBase::class.java, "exam")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return instance!!
        }
    }
}
