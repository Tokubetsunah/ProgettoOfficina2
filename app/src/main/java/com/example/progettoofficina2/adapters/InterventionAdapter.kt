package com.example.progettoofficina2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.lifecycle.LiveData
import com.example.progettoofficina2.R
import com.example.progettoofficina2.entities.Intervention

class InterventionAdapter(context: Context, private val interventionsLiveData: LiveData<List<Intervention>>) : ArrayAdapter<Intervention>(context, 0) {

    init {
        interventionsLiveData.value?.let { addAll(it) }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val intervention = getItem(position)
        var view = convertView ?: LayoutInflater.from(context).inflate(R.layout.intervention_item, parent, false)

        val carTextView = view.findViewById<TextView>(R.id.carTextView)
        val hoursTextView = view.findViewById<TextView>(R.id.hoursTextView)
        val descriptionTextView = view.findViewById<TextView>(R.id.descriptionTextView)
        val startDateTextView = view.findViewById<TextView>(R.id.dateTextView)
        val finishDateTextView = view.findViewById<TextView>(R.id.date2TextView)

        carTextView.text = intervention?.car.toString()
        hoursTextView.text = intervention?.hours
        descriptionTextView.text = intervention?.description
        startDateTextView.text = intervention?.startDate
        finishDateTextView.text = intervention?.finishDate

        return view
    }
}
