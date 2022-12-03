package com.example.doctorapp.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.doctorapp.NEW_PATIENT_ID

@Entity(tableName = "patients")
data class PatientEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "patient_name") val patient_name: String,
    @ColumnInfo(name = "patient_OHIP") val patient_OHIP: String?,
    @ColumnInfo(name = "patient_DOB") val patient_DOB: String?,
    @ColumnInfo(name = "patient_gender") val patient_gender: String?,
    @ColumnInfo(name = "patient_phone") val patient_phone: String?,
    @ColumnInfo(name = "patient_email") val patient_email: String?,
    @ColumnInfo(name = "patient_address") val patient_address: String?,
    @Embedded val patient_medicalrecord: PatientMedicalRecord?
)
{
   /* constructor() : this(
        NEW_PATIENT_ID,
        "John",
        "zz9876543210",
        "2000-01-01",
        "male",
        "416-777-88888",
        "john@gmail.com",
        "12345 Yonge Street, Toronto, ON"
    )*/

    /*
    constructor(
        id: Int,
        name: String,
        OHIP: String,
        DOB: String,
        gender: String,
        phone: String,
        email: String,
        address: String,
        patient_medicalrecord: PatientMedicalRecord
    ) : this(
        id,
        name,
        OHIP,
        DOB,
        gender,
        phone,
        email,
        address,
        patient_medicalrecord
    ){
        this,id = id,
        this.patient_name = name,
        this.patient_OHIP = OHIP,
        this.patient_DOB - DOB,
        this.patient_gender = gender,
        this.patient_phone = phone,
        this.patient_email = email,
        this.patient_address = address,
        this.patient_medicalrecord = patient_medicalrecord
    }*/
}

data class PatientMedicalRecord(
    val height_cm: Int?,
    val weight_kg: Int?,
    val blood_pressure_kPa: Int?,
    val allergies: String?,
    val asthma: Boolean?,
    val diabetes: Boolean?,
    val hospitalization: String?,
    val seizures: Boolean?,
    val chest_pain: Boolean?,
    val headaches: Boolean?,
    val heart_attack: Boolean?,
    val concussion: Boolean?,
    val muscle_cramps: Boolean?,
    val orthotics: Boolean?,
    //val medical_reports: MedicalReport?
)



//https://developer.android.com/training/data-storage/room/relationships#nested-objects
/**
 * Create embedded objects

Sometimes, you'd like to express an entity or data object as a cohesive whole in your database logic,
even if the object contains several fields.

In these situations, you can use the @Embedded annotation to represent an object
that you'd like to decompose into its subfields within a table.
You can then query the embedded fields just as you would for other individual columns.

For instance, your User class can include a field of type Address,
which represents a composition of fields named street, city, state, and postCode.

To store the composed columns separately in the table,
include an Address field in the User class that is annotated with @Embedded,
as shown in the following code snippet:

Kotlin:

data class Address(
val street: String?,
val state: String?,
val city: String?,
@ColumnInfo(name = "post_code") val postCode: Int
)


@Entity
data class User(
@PrimaryKey val id: Int,
val firstName: String?,
@Embedded val address: Address?
)

The table representing a User object then contains columns
with the following names: id, firstName, street, state, city, and post_code.

 */