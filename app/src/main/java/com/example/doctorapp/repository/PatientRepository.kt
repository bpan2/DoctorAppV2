package com.example.doctorapp.repository

import androidx.lifecycle.LiveData
import com.example.doctorapp.database.AppDatabase
import com.example.doctorapp.models.PatientEntity

class PatientRepository(private val patientDB: AppDatabase?) {
    //operations on a single patient
    suspend fun insertPatient(patientEntity: PatientEntity) = patientDB?.patientDao()?.insertPatient(patientEntity)
    suspend fun getPatientById(id: Int) = patientDB?.patientDao()?.getPatientById(id)
    suspend fun updatePatient(patientEntity: PatientEntity) = patientDB?.patientDao()?.updatePatient(patientEntity)
    suspend fun deletePatientById(id: Int) = patientDB?.patientDao()?.deletePatientById(id)
    suspend fun deletePatient(patient: PatientEntity) = patientDB?.patientDao()?.deletePatient(patient)

    //operations on all patients
    suspend  fun insertAll(patients: List<PatientEntity>) = patientDB?.patientDao()?.insertAll(patients)
    fun getAllPatients(): LiveData<List<PatientEntity>>? = patientDB?.patientDao()?.getAllPatients()
    suspend fun deleteAllPatients() = patientDB?.patientDao()?.deleteAllPatients()

}