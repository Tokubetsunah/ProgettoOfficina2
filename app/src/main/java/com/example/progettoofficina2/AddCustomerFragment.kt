package com.example.progettoofficina2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.progettoofficina2.db.DbOfficina
import com.example.progettoofficina2.entities.Customer
import com.example.progettoofficina2.services.CustomerDao
import kotlinx.coroutines.launch


class AddCustomerFragment : Fragment() {

    private lateinit var customerDao: CustomerDao
    private lateinit var nameEditText: EditText
    private lateinit var surnameEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var emailEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_customer, container, false)

        val db = DbOfficina.getDatabase(requireContext())
        customerDao = db.customerDao()

        nameEditText = view.findViewById(R.id.nameEditText)
        surnameEditText = view.findViewById(R.id.surnameEditText)
        phoneEditText = view.findViewById(R.id.phoneEditText)
        emailEditText = view.findViewById(R.id.emailEditText)

        view.findViewById<Button>(R.id.addButton).setOnClickListener {
            val name = nameEditText.text.toString()
            val surname = surnameEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val email = emailEditText.text.toString()

            val customer = Customer( name, surname, phone, email)
            lifecycleScope.launch {
                customerDao.insert(customer)
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

        return view
    }
}
