package com.example.progettoofficina2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Database
import com.example.progettoofficina2.adapters.CarAdapter
import com.example.progettoofficina2.db.Data
import com.example.progettoofficina2.entities.Car
import com.example.progettoofficina2.services.CarDao

class CarManagerFragment : Fragment() {
    //returns a list of all the cars in the database
    private fun getAllCars(): List<Car> {
        return Data.carDao.getAllCars()
    }
}