package com.example.progettoofficina2.services

// import all the needed classes
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.progettoofficina2.entities.Car

// car dao interface, with all the needed queries
@Dao
interface CarDao {

    //get all cars 
    @Query("SELECT * FROM car")
    fun getAll(): LiveData<List<Car>>

    //insert a car
    @Insert
    suspend fun insert(car: Car)

    //delete a car
    @Delete
    suspend fun delete(car: Car)

    //get by id
    @Query("SELECT * FROM car WHERE id = :id")
    fun getById(id: Int): LiveData<Car>
}
