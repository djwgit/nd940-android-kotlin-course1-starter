package com.udacity.shoestore.list


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class ShoeListAdapter(items:MutableList<Shoe>, context: Context)
    : ArrayAdapter<Shoe>(context, R.layout.shoe_item, items) {

    private class ShoeItemViewHolder {
        internal var image: ImageView? = null
        internal var name: TextView? = null
        internal var company: TextView? = null
        internal var size: TextView? = null
        internal var description: TextView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val viewHolder : ShoeItemViewHolder

        if (view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.shoe_item, parent,false)

            viewHolder = ShoeItemViewHolder()
            viewHolder.name = view!!.findViewById<View>(R.id.shoe_name) as TextView
            viewHolder.size = view!!.findViewById<View>(R.id.shoe_size) as TextView
            viewHolder.company = view!!.findViewById<View>(R.id.shoe_company) as TextView
            viewHolder.description = view!!.findViewById<View>(R.id.shoe_description) as TextView
        } else {
            viewHolder = view.tag as ShoeItemViewHolder
        }

        val shoe = getItem(position)
        viewHolder.name!!.text = shoe?.name
        viewHolder.company!!.text = shoe?.company
        viewHolder.size!!.text = shoe?.size.toString()
        viewHolder.description!!.text = shoe?.description

        return view
    }
}