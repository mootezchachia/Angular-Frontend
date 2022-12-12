package tn.esprit.curriculumvitae.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "education")
data class Education (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "university_name")
    val universityName: String,

    @ColumnInfo(name = "university_address")
    val universityAddress: String,

    @ColumnInfo(name = "start_date")
    val startDate: String,

    @ColumnInfo(name = "end_date")
    val endDate: String,

    @ColumnInfo(name = "logo_uri")
    val universityLogo: String
){
    constructor(universityName: String, universityAddress: String, startDate: String, endDate: String, universityLogo: String):
            this(0,universityName,universityAddress, startDate, endDate, universityLogo)
}