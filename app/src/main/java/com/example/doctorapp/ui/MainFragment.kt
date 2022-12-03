package com.example.doctorapp.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctorapp.util.PatientsListAdapter
import com.example.doctorapp.TAG
import com.example.doctorapp.databinding.FragmentMainBinding
import com.example.doctorapp.viewmodels.MainViewModel

class MainFragment : Fragment(), PatientsListAdapter.ListItemListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: PatientsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //disable the display of up-button on Home Screen's Action Bar
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        with(binding.recyclerView){
            setHasFixedSize(true)
            val divider = DividerItemDecoration(
                context, LinearLayoutManager(context).orientation
            )
            addItemDecoration(divider)
        }

        viewModel.patientsList.observe(viewLifecycleOwner, Observer {
            Log.i(TAG, it.toString())
            adapter = PatientsListAdapter(it, this@MainFragment)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        })

        return binding.root
    }

    override fun onItemClick(patientId: Int) {
        Log.i(TAG, "onItemClick: received patient id $patientId")
        val action = MainFragmentDirections.actionEditPatient(patientId)
        findNavController().navigate(action)
    }

}