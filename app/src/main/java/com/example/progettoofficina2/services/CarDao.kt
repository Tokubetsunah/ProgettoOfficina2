package com.example.progettoofficina2.services

// import all the needed classes
import androidx.room.*
import com.example.progettoofficina2.entities.Car

// car dao interface, with all the needed queries
@Dao
interface CarDao {
    @Query("SELECT * FROM car")
    fun getAll(): List<Car>

    @Query("SELECT * FROM car WHERE id IN (:carIds)")
    fun loadAllByIds(carIds: IntArray): List<Car>

    @Query("SELECT * FROM car WHERE owner = :owner")
    fun loadAllByOwner(owner: Int): List<Car>

    @Query("SELECT * FROM car WHERE plate = :plate")
    fun loadByPlate(plate: String): Car

    @Insert
    abstract fun insert(car: Car)

    @Delete
    fun delete(car: Car)

    @Update
    fun update(car: Car)

}