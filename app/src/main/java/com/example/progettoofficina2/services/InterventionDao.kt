package com.example.progettoofficina2.services

// import all the needed classes
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.progettoofficina2.entities.Intervention

// intervention dao interface, with all the needed queries
@Dao
interface InterventionDao {

    //get all interventions
    @Query("SELECT * FROM intervention")
    fun getAll(): LiveData<List<Intervention>>

    //insert an intervention
    @Insert
    suspend fun insert(intervention: Intervention)

    //delete an intervention
    @Delete
    suspend fun delete(intervention: Intervention)


    //get by id
    @Query("SELECT * FROM intervention WHERE id = :id")
    fun getById(id: Int): LiveData<Intervention>
}
