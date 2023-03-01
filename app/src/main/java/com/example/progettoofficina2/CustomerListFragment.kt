package com.example.progettoofficina2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progettoofficina2.adapters.CustomerAdapter
import com.example.progettoofficina2.db.DbOfficina
import com.example.progettoofficina2.services.CustomerDao
class CustomerListFragment : Fragment() {

    private lateinit var customerDao: CustomerDao
    private lateinit var customerListView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_customer_list, container, false)

        val db = DbOfficina.getDatabase(requireContext())
        customerDao = db.customerDao()
        val customersLiveData = customerDao.getAll()

        customerListView = view.findViewById(R.id.listView)
        customerListView.adapter = CustomerAdapter(requireContext(), customersLiveData)

        customersLiveData.observe(viewLifecycleOwner, Observer { customers ->
            (customerListView.adapter as CustomerAdapter).run {
                clear()
                addAll(customers)
                notifyDataSetChanged()
            }
        })

        return view
    }
}





