package com.example.doctorapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.doctorapp.database.AppDatabase
import com.example.doctorapp.models.PatientEntity
import com.example.doctorapp.repository.PatientRepository

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val patientRepository: PatientRepository
    var patientsList: LiveData<List<PatientEntity>>?

    init {
        val patientDB = AppDatabase.getInstance(app)
        patientRepository = PatientRepository(patientDB)
        patientsList = patientRepository.getAllPatients()
    }

}
