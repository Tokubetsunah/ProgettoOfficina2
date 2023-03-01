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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Dichiarazione delle variabili
        private lateinit var carDao: CarDao
        private lateinit var plateEditText: EditText
        private lateinit var modelEditText: EditText
        private lateinit var yearEditText: EditText
        private lateinit var ownerIdEditText: EditText

        // Metodo onCreateView per creare la View del Fragment
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {

            // Se savedInstanceState non è null, chiamare il metodo onCreateView della superclasse
            if (savedInstanceState != null) {
                return super.onCreateView(inflater, container, savedInstanceState)
            }

            // Infla il layout del Fragment
            val view = inflater.inflate(R.layout.fragment_add_car, container, false)

            // Ottenere il riferimento al database e alla DAO per le auto
            val db = DbOfficina.getDatabase(requireContext())
            carDao = db.carDao()

            // Inizializzare i riferimenti alle EditText nel layout
            plateEditText = view.findViewById(R.id.plateEditText)
            modelEditText = view.findViewById(R.id.modelEditText)
            yearEditText = view.findViewById(R.id.yearEditText)
            ownerIdEditText = view.findViewById(R.id.ownerIdEditText)

            // Impostare un listener sul pulsante Aggiungi
            view.findViewById<Button>(R.id.addButton).setOnClickListener {

                // Ottenere i valori inseriti dall'utente dalle EditText
                val plate = plateEditText.text.toString()
                val model = modelEditText.text.toString()
                val year = yearEditText.text.toString()
                val ownerId = ownerIdEditText.text.toString().toInt()

                // Creare un nuovo oggetto Car con i valori inseriti dall'utente
                val car = Car(plate, model, year, ownerId)

                // Avviare un nuovo coroutine per eseguire l'inserimento dell'auto nel database
                lifecycleScope.launch {
                    carDao.insert(car)
                    requireActivity().supportFragmentManager.popBackStack()
                }
            }

            // Restituire la View creata
            return view
        }

    }
}


