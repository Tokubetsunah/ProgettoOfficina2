package com.example.progettoofficina2.services

// import all the needed classes
import androidx.room.*
import com.example.progettoofficina2.entities.Customer

// customer dao interface, with all the needed queries
@Dao
interface CustomerDao {
    //get all the customers
    @Query("SELECT * FROM customer")
    fun getAllCustomers(): List<Customer>

    //insert a customer
    @Insert
    fun insertCustomer(customer: Customer)

    //delete a customer
    @Delete
    fun deleteCustomer(customer: Customer)

}