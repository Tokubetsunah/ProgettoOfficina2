package com.example.progettoofficina2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.progettoofficina2.R
import com.example.progettoofficina2.entities.Intervention

class InterventionAdapter(private var interventionsLiveData: LiveData<List<Intervention>>) : RecyclerView.Adapter<InterventionAdapter.InterventionViewHolder>() {

    class InterventionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carTextView: TextView = itemView.findViewById(R.id.carTextView)
        val hoursTextView: TextView = itemView.findViewById(R.id.hoursTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        val startDateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        val finishDateTextView: TextView = itemView.findViewById(R.id.date2TextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InterventionViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.intervention_item, parent, false)
        return InterventionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: InterventionViewHolder, position: Int) {
        val interventions = interventionsLiveData.value
        if (interventions != null && interventions.isNotEmpty()) {
            val intervention = interventions[position]
            holder.carTextView.text = intervention.car.toString()
            holder.hoursTextView.text = intervention.hours
            holder.descriptionTextView.text = intervention.description
            holder.startDateTextView.text = intervention.startDate
            holder.finishDateTextView.text = intervention.finishDate
        }
    }

    override fun getItemCount(): Int {
        val interventions = interventionsLiveData.value
        return if (interventions != null) interventions.size else 0
    }
}
