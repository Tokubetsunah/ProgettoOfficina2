package com.example.progettoofficina2.services

// import all the needed classes
import androidx.room.*
import com.example.progettoofficina2.entities.Intervention

// intervention dao interface, with all the needed queries
@Dao
interface InterventionDao {
    @Query("SELECT * FROM intervention")
    fun getAll(): List<Intervention>

    @Insert
    fun insert(intervention: Intervention)

    @Delete
    fun delete(intervention: Intervention)

    @Update
    fun update(intervention: Intervention)


}