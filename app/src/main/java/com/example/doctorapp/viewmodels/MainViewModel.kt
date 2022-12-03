package com.example.doctorapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.doctorapp.models.PatientEntity
import com.example.doctorapp.models.SampleDataProvider

class MainViewModel : ViewModel() {

 val patientsList = MutableLiveData<List<PatientEntity>>()

    init{
        patientsList.value = SampleDataProvider.getPatients()
    }

}
