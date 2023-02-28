package com.example.progettoofficina2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.progettoofficina2.R
import com.example.progettoofficina2.entities.Intervention

//adapter for interventions
class InterventionAdapter(context: Context, private val interventions: List<Intervention>) : ArrayAdapter<Intervention>(context, 0, interventions) {
        //creates the view for the listview
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            
        //get the intervention
        val intervention = interventions[position]
        
        //inflate the view
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.intervention_item, parent, false)
        
        //initialize the textviews
        val tvId = view.findViewById<TextView>(R.id.tvIdIntervention)
        val tvCar = view.findViewById<TextView>(R.id.tvCar)
        val tvDate = view.findViewById<TextView>(R.id.tvDate)
        val tvKm = view.findViewById<TextView>(R.id.tvHours)
        val tvDescription = view.findViewById<TextView>(R.id.tvDescription)

        //set the textviews
        tvId.text = intervention.id.toString()
        tvCar.text = intervention.car.toString()
        tvDate.text = intervention.date
        tvKm.text = intervention.hours.toString()
        tvDescription.text = intervention.description

        //return the view
        return view
    }
}