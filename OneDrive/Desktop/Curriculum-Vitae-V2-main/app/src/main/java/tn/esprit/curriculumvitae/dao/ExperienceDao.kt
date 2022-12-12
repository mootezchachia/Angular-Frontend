package tn.esprit.curriculumvitae.dao

import androidx.room.*
import tn.esprit.curriculumvitae.data.Experience

@Dao
interface ExperienceDao {
    @Insert
    fun insert(exp: Experience)

    @Update
    fun update(exp: Experience)

    @Delete
    fun delete(exp: Experience)

    @Query("SELECT * FROM experience")
    fun getAllExperiences(): MutableList<Experience>
}