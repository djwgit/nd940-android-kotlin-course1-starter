package com.udacity.shoestore.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.view.ShoeListFragmentDirections
import com.udacity.shoestore.viewmodel.AppViewModel


class ShoeListFragment : Fragment() {

    private val viewModel: AppViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var listBinding: ShoeItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.fab.setOnClickListener{
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToDetailFragment())
        }

        binding.lifecycleOwner = this
        viewModel.shoes.observe(this.viewLifecycleOwner, Observer{
            val outerLinearlayout = binding.shoesLinearlayout
            val shoes = viewModel.shoes.value
            if (shoes != null) {
                for (shoe in shoes) {
                    listBinding = DataBindingUtil.inflate(
                        layoutInflater,
                        R.layout.shoe_item,
                        outerLinearlayout,
                        false
                    )

                    listBinding.shoe = shoe
                    outerLinearlayout.addView(listBinding.root)
                }
            }
        })

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Shoes List"
    }

}