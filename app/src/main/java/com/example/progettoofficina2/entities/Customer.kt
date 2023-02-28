package com.example.progettoofficina2.entities
// customer class with all the information about the car, uses room db annotations, id is autogenerate and not in the constructor
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "customer")
data class Customer(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "surname") val surname: String,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "email") val email: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
) : Serializable
