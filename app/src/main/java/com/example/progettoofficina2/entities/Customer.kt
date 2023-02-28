package com.example.progettoofficina2.entities
// customer class with all the information about the car, uses room db annotations
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "customer")
data class Customer(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "surname")
    var surname: String,
    @ColumnInfo(name = "phone")
    var phone: String,
    @ColumnInfo(name = "email")
    var email: String
) : Serializable
