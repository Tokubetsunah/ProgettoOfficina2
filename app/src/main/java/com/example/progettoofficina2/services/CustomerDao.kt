package com.example.progettoofficina2.services

// import all the needed classes
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.progettoofficina2.entities.Customer

// customer dao interface, with all the needed queries
@Dao
interface CustomerDao {
    //get all customers
    @Query("SELECT * FROM customer")
    fun getAll(): LiveData<List<Customer>>

    //get all customers as a list
    @Query("SELECT * FROM customer")
    suspend fun getAllList(): List<Customer>

    //get a customer by ID
    @Query("SELECT * FROM customer WHERE id=:id")
    fun getById(id: Int): LiveData<Customer>

    //insert a customer
    @Insert
    suspend fun insert(customer: Customer)

    //update a customer
    @Update
    suspend fun update(customer: Customer)

    //delete a customer
    @Delete
    suspend fun delete(customer: Customer)
}
