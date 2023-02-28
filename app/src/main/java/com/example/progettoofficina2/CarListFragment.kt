package com.example.progettoofficina2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progettoofficina2.adapters.CarAdapter
import com.example.progettoofficina2.db.DbOfficina
import com.example.progettoofficina2.services.CarDao

//class that creates the fragment for the car manager(see all cars, add a car)
class CarListFragment : Fragment() {

    private lateinit var carDao: CarDao
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_car_list, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = DbOfficina.getDatabase(requireContext())
        carDao = db.carDao()

        val cars = carDao.getAll()
        val adapter = CarAdapter(cars)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}

