package com.example.doctorapp.models

data class MedicalReport (
    val examination_type: String,
    val hospital_name: String,
    val examination_date: String,
    val examination_result: String
)

//examination_type: CT-Scan, X-ray, MRI