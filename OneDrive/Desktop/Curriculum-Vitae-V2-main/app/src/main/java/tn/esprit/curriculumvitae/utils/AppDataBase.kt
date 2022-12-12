package tn.esprit.curriculumvitae.utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tn.esprit.curriculumvitae.dao.EducationDao
import tn.esprit.curriculumvitae.dao.ExperienceDao
import tn.esprit.curriculumvitae.data.Education
import tn.esprit.curriculumvitae.data.Experience

@Database(entities = [Education::class, Experience::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun experienceDao(): ExperienceDao
    abstract fun educationDao(): EducationDao

    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            if (instance == null) {
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(context, AppDataBase::class.java, "curriculum_vitae_database")
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return instance!!
        }
    }
}


