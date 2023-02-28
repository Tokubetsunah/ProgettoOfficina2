package com.example.progettoofficina2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.progettoofficina2.R
import com.example.progettoofficina2.entities.Customer

class CustomerAdapter(private val customersLiveData: LiveData<List<Customer>>) : RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {

    class CustomerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.customer_name_text_view)
        val surnameTextView: TextView = itemView.findViewById(R.id.customer_surname_text_view)
        val phoneTextView: TextView = itemView.findViewById(R.id.customer_phone_text_view)
        val emailTextView: TextView = itemView.findViewById(R.id.customer_email_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.customer_item, parent, false)
        return CustomerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val customers = customersLiveData.value
        if (customers != null && customers.isNotEmpty()) {
            val customer = customers[position]
            holder.nameTextView.text = customer.name
            holder.surnameTextView.text = customer.surname
            holder.phoneTextView.text = customer.phone
            holder.emailTextView.text = customer.email
        }
    }

    override fun getItemCount(): Int {
        val customers = customersLiveData.value
        return if (customers != null) customers.size else 0
    }
}

