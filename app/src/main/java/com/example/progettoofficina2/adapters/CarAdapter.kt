package com.example.progettoofficina2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.progettoofficina2.R
import com.example.progettoofficina2.entities.Car

//Adapter for cars
class CarAdapter(context: List<Car>, private val cars: List<Car>) : ArrayAdapter<Car>(context, 0, cars) {
    //creates the view for the listview
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //get the car
        val car = cars[position]
        //inflate the view
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.car_item, parent, false)
        //initialize the textviews
        val tvId = view.findViewById<TextView>(R.id.tvCarId)
        val tvPlate = view.findViewById<TextView>(R.id.tvPlate)
        val tvModel = view.findViewById<TextView>(R.id.tvModel)
        val tvYear = view.findViewById<TextView>(R.id.tvYear)
        val tvOwner = view.findViewById<TextView>(R.id.tvOwner)
        //set the textviews
        tvPlate.text = car.plate
        tvModel.text = car.brand
        tvModel.text = car.model
        tvYear.text = car.year.toString()
        tvOwner.text = car.owner
        //return the view
        return view
    }
}