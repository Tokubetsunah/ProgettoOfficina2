package com.example.progettoofficina2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.lifecycle.LiveData
import com.example.progettoofficina2.R
import com.example.progettoofficina2.entities.Customer

class CustomerAdapter(context: Context, private val customersLiveData: LiveData<List<Customer>>) : ArrayAdapter<Customer>(context, 0) {

    init {
        customersLiveData.value?.let { addAll(it) }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val customer = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.customer_item, parent, false)

        val nameTextView = view.findViewById<TextView>(R.id.customer_name_text_view)
        val surnameTextView = view.findViewById<TextView>(R.id.customer_surname_text_view)
        val phoneTextView = view.findViewById<TextView>(R.id.customer_phone_text_view)
        val emailTextView = view.findViewById<TextView>(R.id.customer_email_text_view)

        nameTextView.text = customer?.name
        surnameTextView.text = customer?.surname
        phoneTextView.text = customer?.phone
        emailTextView.text = customer?.email

        return view
    }
}

