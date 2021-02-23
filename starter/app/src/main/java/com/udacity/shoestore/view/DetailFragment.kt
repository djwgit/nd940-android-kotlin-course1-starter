package com.udacity.shoestore.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.view.DetailFragmentDirections
import com.udacity.shoestore.viewmodel.AppViewModel
import com.udacity.shoestore.models.Shoe



class DetailFragment : Fragment() {

    private lateinit var binding:FragmentDetailBinding
    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        binding.cancelShoeButton.setOnClickListener{
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoeListFragment())
        }

        binding.addShoeButton.setOnClickListener{
            val shoes = viewModel.shoes.value
            val name = binding.newShoeName.text.toString()
            val size = binding.newShoeSize.text.toString().toDouble()
            val company = binding.newShoeCompany.text.toString()
            val description = binding.newShoeDescription.text.toString()
            shoes?.add( Shoe(name, size, company, description, mutableListOf("url") ))

            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoeListFragment())
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        (activity as? AppCompatActivity)?.supportActionBar?.title = "New Shoe"
    }
}