package com.example.progettoofficina2

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, CarListFragment()).commit()

        val addCarButton: Button = findViewById(R.id.addCarButton)
        addCarButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, AddCarFragment()).addToBackStack(null).commit()
        }

        val addCustomerButton: Button = findViewById(R.id.addCustomerButton)
        addCustomerButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, AddCustomerFragment()).addToBackStack(null).commit()
        }

        val addInterventionButton: Button = findViewById(R.id.addInterventionButton)
        addInterventionButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, AddInterventionFragment()).addToBackStack(null).commit()
        }

        val carsButton: Button = findViewById(R.id.carsButton)
        carsButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, CarListFragment()).commit()
        }

        val customersButton: Button = findViewById(R.id.customersButton)
        customersButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, CustomerListFragment()).commit()
        }

        val interventionsButton: Button = findViewById(R.id.interventionsButton)
        interventionsButton.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, InterventionListFragment()).commit()
        }
    }
}




