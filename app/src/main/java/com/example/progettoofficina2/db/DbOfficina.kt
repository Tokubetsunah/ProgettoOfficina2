package com.example.progettoofficina2.db

//database of the classes customer, car and itnerventions using android room db, the class is called datimacchine
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.progettoofficina2.entities.Car
import com.example.progettoofficina2.entities.Customer
import com.example.progettoofficina2.entities.Intervention
import com.example.progettoofficina2.services.CarDao
import com.example.progettoofficina2.services.CustomerDao
import com.example.progettoofficina2.services.InterventionDao

@Database(entities = [Customer::class, Car::class, Intervention::class], version = 1, exportSchema = false)
abstract class DbOfficina : RoomDatabase() {
    abstract fun customerDao(): CustomerDao
    abstract fun carDao(): CarDao
    abstract fun interventionDao(): InterventionDao

    //get the instance of the database
    companion object {

        @Volatile
        private var INSTANCE: DbOfficina? = null

        fun getDatabase(context: Context): DbOfficina {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DbOfficina::class.java,
                    "datimacchine"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}

