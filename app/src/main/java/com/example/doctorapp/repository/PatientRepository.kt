package com.example.doctorapp.repository

import androidx.lifecycle.LiveData
import com.example.doctorapp.database.PatientDao
import com.example.doctorapp.models.Patient
import com.example.doctorapp.models.PatientEntity

class PatientRepository(private val patientDao: PatientDao) {
    //operations on a single patient
    suspend fun insertPatient(patientEntity: PatientEntity) = patientDao.insertPatient(patientEntity)
    suspend fun getPatientById(id: Int) = patientDao.getPatientById(id)
    suspend fun updatePatient(patientEntity: PatientEntity) = patientDao.updatePatient(patientEntity)
    suspend fun deletePatientById(id: Int) = patientDao.deletePatientById(id)
    suspend fun deletePatient(patient: PatientEntity) = patientDao.deletePatient(patient)

    //operations on all patients
    suspend  fun insertAll(patients: List<PatientEntity>) = patientDao.insertAll(patients)
    fun getAllPatients(): LiveData<List<PatientEntity>> =  patientDao.getAllPatients()
    suspend fun deleteAllPatients() = patientDao.deleteAllPatients()

}