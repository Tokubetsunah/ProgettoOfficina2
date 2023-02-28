package com.example.progettoofficina2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.progettoofficina2.R
import com.example.progettoofficina2.entities.Customer

//adapter for customers
class CustomerAdapter(context: Context, private val customers: List<Customer>) : ArrayAdapter<Customer>(context, 0, customers) {
    
    //creates the view for the listview
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        
        //get the customer
        val customer = customers[position]
        
        //inflate the view
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.customer_item, parent, false)
        
        //initialize the textviews
        val tvId = view.findViewById<TextView>(R.id.tvIdCustomer)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvSurname = view.findViewById<TextView>(R.id.tvSurname)
        val tvPhone = view.findViewById<TextView>(R.id.tvPhone)
        val tvEmail = view.findViewById<TextView>(R.id.tvEmail)
        
        //set the textviews
        tvId.text = customer.id.toString()
        tvName.text = customer.name
        tvSurname.text = customer.surname
        tvPhone.text = customer.phone
        tvEmail.text = customer.email
        
        //return the view
        return view
    }
}