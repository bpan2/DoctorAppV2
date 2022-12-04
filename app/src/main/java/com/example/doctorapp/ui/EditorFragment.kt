package com.example.doctorapp.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.doctorapp.R
import com.example.doctorapp.databinding.FragmentEditorBinding
import com.example.doctorapp.viewmodels.EditorViewModel

class EditorFragment : Fragment() {

    private lateinit var viewModel: EditorViewModel
    private val args: EditorFragmentArgs by navArgs()
    private lateinit var binding: FragmentEditorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //create the up-button(by using check icon) on the action bar to navigate back to the home screen
        (activity as AppCompatActivity).supportActionBar?.let{
            it.setHomeButtonEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_check_circle)
        }
        setHasOptionsMenu(true)

        viewModel = ViewModelProvider(this).get(EditorViewModel::class.java)

        binding = FragmentEditorBinding.inflate(inflater, container, false)
        binding.nameOutlinedTextField.editText?.setText("")
        binding.OHIPIdOutlinedTextField.editText?.setText("")
        binding.dobOutlinedTextField.editText?.setText("")
        binding.genderOutlinedTextField.editText?.setText("")
        binding.phoneOutlinedTextField.editText?.setText("")
        binding.addressOutlinedTextField.editText?.setText("")
        binding.emailOutlinedTextField.editText?.setText("")

        //enalbe the device's back-button or back gesture to navigate from Editor screen back to Home Screen
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    saveAndReturn()
                }
            }
        )

        viewModel.currentPatient.observe(viewLifecycleOwner, Observer {
            binding.nameOutlinedTextField.editText?.setText(it?.patient_name ?: "")
            binding.OHIPIdOutlinedTextField.editText?.setText(it?.patient_OHIP ?: "")
            binding.dobOutlinedTextField.editText?.setText(it?.patient_DOB ?: "")
            binding.genderOutlinedTextField.editText?.setText(it?.patient_gender ?:"")
            binding.phoneOutlinedTextField.editText?.setText(it?.patient_phone ?:"")
            binding.addressOutlinedTextField.editText?.setText(it?.patient_address ?:"")
            binding.emailOutlinedTextField.editText?.setText(it?.patient_email ?:"")
        })

        viewModel.getPatientById(args.patientId)

        return binding.root
    }

    //enable the funcationality of the up-button
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> saveAndReturn()
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun saveAndReturn(): Boolean {
        findNavController().navigateUp()
        return true
    }
}