package com.example.progettoofficina2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.progettoofficina2.db.DbOfficina
import com.example.progettoofficina2.entities.Car
import com.example.progettoofficina2.services.CarDao
import kotlinx.coroutines.launch

class AddCarFragment : Fragment() {
    private lateinit var carDao: CarDao
    private lateinit var plateEditText: EditText
    private lateinit var modelEditText: EditText
    private lateinit var yearEditText: EditText
    private lateinit var ownerIdEditText: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_add_car, container, false)

        val db = DbOfficina.getDatabase(requireContext())
        carDao = db.carDao()

        plateEditText = view.findViewById(R.id.plateEditText)
        modelEditText = view.findViewById(R.id.modelEditText)
        yearEditText = view.findViewById(R.id.yearEditText)
        ownerIdEditText = view.findViewById(R.id.ownerIdEditText)

        view.findViewById<Button>(R.id.addButton).setOnClickListener {
            val plate = plateEditText.text.toString()
            val model = modelEditText.text.toString()
            val year = yearEditText.text.toString()
            val ownerId = ownerIdEditText.text.toString().toInt()

            val car = Car(plate, model, year, ownerId)
            lifecycleScope.launch {
                carDao.insert(car)
                requireActivity().supportFragmentManager.popBackStack()
            }
        }

        return view
    }

}

