package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe


class AppViewModel: ViewModel() {
    private var _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    // data from amazon.com
    init {
        _shoes.value = mutableListOf(
            Shoe("Women's Fluff Yeah Slide Slipper",
                8.0,
                "UGG",
                "$99.95",
                mutableListOf("https://m.media-amazon.com/images/I/71-SXjhnrfL._AC_UL800_FMwebp_QL65_.jpg")),
            Shoe("Women's Summits-Quick Getaway Sneaker",
                9.0,
                "Skechers",
                "$32.99",
                mutableListOf("https://m.media-amazon.com/images/I/81wjCtEL03L._AC_UL800_FMwebp_QL65_.jpg")),
            Shoe("Men's Lite Racer Adapt 3.0 Running",
                9.0,
                "adidas",
                "$54.98",
                mutableListOf("https://m.media-amazon.com/images/I/81WqANXnjaL._AC_UL800_FMwebp_QL65_.jpg")),
            Shoe("Men's 608 V5 Casual Comfort Cross Trainer",
                9.0,
                "New Balance",
                "$52.97",
                mutableListOf("https://m.media-amazon.com/images/I/71I2Hf4x0SL._AC_UL800_FMwebp_QL65_.jpg")),
            Shoe("Men's Surge 2 running Shoe",
                9.0, "Under Armor",
                "$69.95",
                mutableListOf("https://m.media-amazon.com/images/I/71vR40mfmLL._AC_UL800_FMwebp_QL65_.jpg"))
        )
    }

    // add a new shoe to list
    fun addToShoes(shoe:Shoe){
        _shoes.value?.add(shoe)
    }
}