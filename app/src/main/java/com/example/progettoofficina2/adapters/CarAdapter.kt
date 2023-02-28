package com.example.progettoofficina2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.progettoofficina2.R
import com.example.progettoofficina2.entities.Car
import com.example.progettoofficina2.entities.Customer

//adapter of the car, takes a car list and populates the recycler view with the car_item layout
class CarAdapter(private var carsLiveData: LiveData<List<Car>>) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val plateTextView: TextView = itemView.findViewById(R.id.plateValueTextView)
        val modelTextView: TextView = itemView.findViewById(R.id.modelValueTextView)
        val yearTextView: TextView = itemView.findViewById(R.id.yearValueTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent, false)
        return CarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val cars = carsLiveData.value
        if (cars != null && cars.isNotEmpty()) {
            val car = cars[position]
            holder.plateTextView.text = car.plate
            holder.modelTextView.text = car.model
            holder.yearTextView.text = car.year
        }
    }

    override fun getItemCount(): Int {
        val cars = carsLiveData.value
        return if (cars != null) cars.size else 0
    }
}

