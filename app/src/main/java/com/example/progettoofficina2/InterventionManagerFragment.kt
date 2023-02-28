package com.example.progettoofficina2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Database
import com.example.progettoofficina2.adapters.InterventionAdapter
import com.example.progettoofficina2.entities.Intervention
import com.example.progettoofficina2.services.InterventionDao


class InterventionManagerFragment : Fragment() {
    //initialize the needed variables
    private lateinit var db : Database
    private lateinit var interventionDao: InterventionDao

    private lateinit var etcarId: EditText
    private lateinit var etCustomerId: EditText
    private lateinit var etDate: EditText
    private lateinit var etHours: EditText
    private lateinit var etDescription: EditText
    private lateinit var btnInterventionAdd: EditText
    private lateinit var rvInterventions: RecyclerView

    //creates the view with the onclicklistener
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_intervention_manager, container, false)

        //initialize the variables
        db = Database.getDatabase(requireContext())
        interventionDao = db.interventionDao()
        etcarId = view.findViewById(R.id.etCarId)
        etDate = view.findViewById(R.id.etDate)
        etHours = view.findViewById(R.id.etHours)
        etDescription = view.findViewById(R.id.etDescription)
        btnInterventionAdd = view.findViewById(R.id.btnAddIntervention)
        btnInterventionAdd.setOnClickListener {

         //show all the intervenrtions in the listview
        rvInterventions.adapter = InterventionAdapter(interventionDao.getAll())

            //create a new intervention
            val intervention = Intervention(
                car = etcarId.text.toString().toInt(),
                date = etDate.text.toString(),
                hours = etHours.text.toString(),
                description = etDescription.text.toString()
            )

            //insert the intervention in the database
            interventionDao.insert(intervention)

            //show a toast
            Toast.makeText(requireContext(), "Intervention added", Toast.LENGTH_SHORT).show()
        }
        return view
    }
}