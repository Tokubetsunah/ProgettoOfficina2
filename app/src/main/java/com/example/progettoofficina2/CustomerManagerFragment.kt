package com.example.progettoofficina2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Database
import com.example.progettoofficina2.adapters.CustomerAdapter
import com.example.progettoofficina2.db.Data
import com.example.progettoofficina2.entities.Customer
import com.example.progettoofficina2.services.CustomerDao


class CustomerManagerFragment : Fragment() {
    //initialize the needed variables
    private lateinit var db : Data
    private lateinit var customerDao: CustomerDao

    private lateinit var etName: EditText
    private lateinit var etSurname: EditText
    private lateinit var etPhone: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnCustomerAdd: Button
    private lateinit var rvCustomers: RecyclerView
    private lateinit var customerAdapter: CustomerAdapter

    //give the adapter the needed data
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = Data.getDatabase(requireContext())
        customerDao = db.customerDao()
        customerAdapter = CustomerAdapter(requireContext(), customerDao.getAllCustomers())
    }

    //creates the view with the onclicklistener
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_customer_manager, container, false)

        //initialize the variables
        etName = view.findViewById(R.id.editTextName)
        etSurname = view.findViewById(R.id.editTextSurname)
        etPhone = view.findViewById(R.id.editTextPhone)
        etEmail = view.findViewById(R.id.editTextEmail)
        btnCustomerAdd = view.findViewById(R.id.buttonAddCustomer)
        btnCustomerAdd.setOnClickListener {

        //show all the customers in the listview
            rvCustomers = view.findViewById(R.id.rvCustomers)

            //create a new customer
            val customer = Customer(
                name = etName.text.toString(),
                surname = etSurname.text.toString(),
                phone = etPhone.text.toString(),
                email = etEmail.text.toString()
            )

            //insert the customer in the database
            customerDao.insertCustomer(customer)

            //show a toast
            Toast.makeText(requireContext(), "Customer added", Toast.LENGTH_SHORT).show()
        }
        return view
    }

}