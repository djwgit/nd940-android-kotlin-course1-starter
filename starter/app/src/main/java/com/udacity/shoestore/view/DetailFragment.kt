package com.udacity.shoestore.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.InverseBindingAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.AppViewModel


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel: AppViewModel by activityViewModels()
    private var shoe: Shoe = Shoe("", 0.0, "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.shoe = shoe

        // cancel
        binding.cancelShoeButton.setOnClickListener {
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoeListFragment())
        }

        // save the shoe
        binding.addShoeButton.setOnClickListener {
            if (shoe.name == "" || shoe.company == "" || shoe.description == "" || shoe.size == 0.0) {
                Toast.makeText(context, "invalid shoe info !", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.addToShoes(shoe)
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoeListFragment())
            }
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        (activity as? AppCompatActivity)?.supportActionBar?.title = "New Shoe"
    }

}