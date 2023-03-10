package com.example.progettoofficina2.entities
// car class with all the information about the car, uses room db annotations, each car has an owner
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "car")
data class Car(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "plate")
    var plate: String,
    @ColumnInfo(name = "model")
    var model: String,
    @ColumnInfo(name = "year")
    var year: String,
    @ColumnInfo(name = "ownerId")
    var ownerId: Int
) : Serializable {
    constructor(plate: String, model: String, year: String, ownerId: Int) : this(0, plate, model, year, ownerId)
}