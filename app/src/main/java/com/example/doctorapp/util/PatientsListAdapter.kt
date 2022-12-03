package com.example.doctorapp.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doctorapp.R
import com.example.doctorapp.databinding.ListItemBinding
import com.example.doctorapp.models.PatientEntity

class PatientsListAdapter (private val patientsList: List<PatientEntity>, private val listener: ListItemListener
                           ):

    RecyclerView.Adapter<PatientsListAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ListItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = patientsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val patient = patientsList[position]
        with(holder.binding){
            patientText.text = patient.patient_name + ": "  + patient.patient_gender + ", "+ patient.patient_DOB
            root.setOnClickListener{
                listener.onItemClick(patient.id)
            }
        }
    }

    interface ListItemListener{
        fun onItemClick(patientId: Int)
    }

}