package tn.esprit.curriculumvitae.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "experience")
data class Experience (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "company_name")
    val companyName: String,

    @ColumnInfo(name = "company_address")
    val companyAddress: String,

    @ColumnInfo(name = "start_date")
    val startDate: String,

    @ColumnInfo(name = "end_date")
    val endDate: String,

    @ColumnInfo(name = "logo_uri")
    val companyLogo: String,

    @ColumnInfo(name = "description")
    val workDescription: String
){
    constructor(companyName: String, companyAddress: String, startDate: String, endDate: String, companyLogo: String, workDescription: String):
            this(0,companyName,companyAddress, startDate, endDate, companyLogo, workDescription)
}