package com.example.progettoofficina2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.progettoofficina2.db.DbOfficina
import com.example.progettoofficina2.entities.Car
import com.example.progettoofficina2.entities.Intervention
import com.example.progettoofficina2.services.CarDao
import com.example.progettoofficina2.services.InterventionDao
import kotlinx.coroutines.launch


class AddInterventionFragment : Fragment() {

    private lateinit var interventionDao: InterventionDao
    private lateinit var carDao: CarDao
    private lateinit var carIdEditText: EditText
    private lateinit var hoursEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var startDateEditText: EditText
    private lateinit var finishDateEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_intervention, container, false)

        val db = DbOfficina.getDatabase(requireContext())
        interventionDao = db.interventionDao()
        carDao = db.carDao()

        carIdEditText = view.findViewById(R.id.carIdEditText)
        hoursEditText = view.findViewById(R.id.hoursEditText)
        descriptionEditText = view.findViewById(R.id.descriptionEditText)
        startDateEditText = view.findViewById(R.id.startDateEditText)
        finishDateEditText = view.findViewById(R.id.finishDateEditText)

        view.findViewById<Button>(R.id.addButton).setOnClickListener {
            val carId = carIdEditText.text.toString().toInt()
            val hours = hoursEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val startDate = startDateEditText.text.toString()
            val finishDate = finishDateEditText.text.toString()

            val intervention = Intervention(
                car = carId,
                hours = hours,
                description = description,
                startDate = startDate,
                finishDate = finishDate
            )

            lifecycleScope.launch {
                interventionDao.insert(intervention)
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

        return view
    }
}

