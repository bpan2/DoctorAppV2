package com.example.doctorapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.doctorapp.NEW_PATIENT_ID
import com.example.doctorapp.models.PatientEntity
import com.example.doctorapp.repository.PatientRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditorViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: PatientRepository = PatientRepository(application)
    val currentPatient = MutableLiveData<PatientEntity?>()

    fun getPatientById(patientId: Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val patient =
                    if(patientId != NEW_PATIENT_ID){
                        repository.getPatientById(patientId)
                    }else{
                        PatientEntity()
                    }
                currentPatient.postValue(patient)
            }
        }
    }
}