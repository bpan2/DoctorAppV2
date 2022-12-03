package com.example.doctorapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.doctorapp.models.PatientEntity

@Dao
interface PatientDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPatient(patient: PatientEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(patients: List<PatientEntity>)

    @Query("SELECT * FROM patients ORDER BY id ASC")
    fun getAllPatients(): LiveData<List<PatientEntity>>

    @Query("SELECT * FROM patients WHERE id = :id")
    fun getPatientById(id: Int): PatientEntity?

    @Delete
    fun deletePatients(selectedPatients: List<PatientEntity>): Int

    @Query("DELETE FROM patients WHERE id = :id")
    fun deletePatientById(id: Int): PatientEntity?

    @Delete
    fun deletePatient(patient: PatientEntity)

    @Query("DELETE FROM patients")
    fun deleteAllPatients(): Int
}