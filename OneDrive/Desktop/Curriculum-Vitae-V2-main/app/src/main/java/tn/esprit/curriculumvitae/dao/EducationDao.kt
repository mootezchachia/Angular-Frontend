package tn.esprit.curriculumvitae.dao

import androidx.room.*
import tn.esprit.curriculumvitae.data.Education

@Dao
interface EducationDao {
    @Insert
    fun insert(edc: Education)

    @Update
    fun update(edc: Education)

    @Delete
    fun delete(edc: Education)

    @Query("SELECT * FROM education")
    fun getAllEducations(): MutableList<Education>
}