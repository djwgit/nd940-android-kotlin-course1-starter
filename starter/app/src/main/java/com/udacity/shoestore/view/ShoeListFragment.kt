package com.udacity.shoestore.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
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

        // fab listener
        binding.fab.setOnClickListener{
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToDetailFragment())
        }

        // show overflow menu
        setHasOptionsMenu(true)

        // shoes list observer
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

    // overflow menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Shoes List"
    }

}