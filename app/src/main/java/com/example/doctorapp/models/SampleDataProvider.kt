package com.example.doctorapp.models

class SampleDataProvider {
    companion object{
        fun getPatients() = arrayListOf(
            PatientEntity(
                "Sam",
                "yy987654321",
                "1999-01-01",
                "male",
                "416-333-5555",
                "sam@gmail.com",
                "7777  Steeles East, Toronto, ON",
            ),
            PatientEntity(
                "Mary",
                "mm0123456789",
                "1988-01-01",
                "female",
                "905-666-55555",
                "mary@hotmail.com",
                "5555 Eglinton West Street, Toronto, ON",
            )
        )
    }
}