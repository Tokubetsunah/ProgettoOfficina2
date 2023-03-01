package com.example.progettoofficina2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.lifecycle.LiveData
import com.example.progettoofficina2.R
import com.example.progettoofficina2.entities.Car

//adapter of the car, takes a car list and populates the recycler view with the car_item layout
class CarAdapter(context: Context, private val carsLiveData: LiveData<List<Car>>) : ArrayAdapter<Car>(context, 0) {

    init {
        carsLiveData.value?.let { addAll(it) }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val car = getItem(position)
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.car_item, parent, false)

        val plateTextView = view.findViewById<TextView>(R.id.plateValueTextView)
        val modelTextView = view.findViewById<TextView>(R.id.modelValueTextView)
        val yearTextView = view.findViewById<TextView>(R.id.yearValueTextView)

        plateTextView.text = car?.plate
        modelTextView.text = car?.model
        yearTextView.text = car?.year

        return view
    }
}


