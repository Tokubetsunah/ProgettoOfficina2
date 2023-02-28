package com.example.progettoofficina2.entities

// intervention class with all the information about the intervention, uses room db annotations, with star date of intervention, finish date and how many hours it took, also the car is ma foregnkey from the cars table
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "intervention")
data class Intervention(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "car_id")
    var car: Int = 0,
    @ColumnInfo(name = "hours")
    var hours: String,
    @ColumnInfo(name = "description")
    var description: String = "",
    @ColumnInfo(name = "start_date")
    var startDate: String = "",
    @ColumnInfo(name = "finish_date")
    var finishDate: String = ""
) : Serializable