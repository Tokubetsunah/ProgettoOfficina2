package com.example.progettoofficina2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.progettoofficina2.adapters.CarAdapter
import com.example.progettoofficina2.db.DbOfficina
import com.example.progettoofficina2.entities.Car
import com.example.progettoofficina2.services.CarDao

//class that creates the fragment for the car manager(see all cars, add a car)
class CarListFragment : Fragment() {

    private lateinit var carDao: CarDao
    private lateinit var carsLiveData: LiveData<List<Car>>
    private lateinit var carListView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_car_list, container, false)

        val db = DbOfficina.getDatabase(requireContext())
        carDao = db.carDao()
        carsLiveData = carDao.getAll()

        carListView = view.findViewById(R.id.listView)
        carListView.adapter = CarAdapter(requireContext(), carsLiveData)

        carsLiveData.observe(viewLifecycleOwner, Observer { cars ->
            (carListView.adapter as CarAdapter).run {
                clear()
                addAll(cars)
                notifyDataSetChanged()
            }
        })

        return view
    }
}



