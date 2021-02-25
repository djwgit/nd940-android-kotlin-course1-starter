package com.udacity.shoestore.view

import androidx.databinding.InverseMethod

// NOT USED !!!
// a converter for two way data binding between a Double and EditText
// https://stackoverflow.com/questions/63280275/android-two-way-data-binding-with-double-kotlin

object Converter {

    @JvmStatic
    @InverseMethod("stringToDouble")
    fun doubleToString(value: Double?): String? {
        if (value == null) {
            return null
        }
        return value.toString()
    }

    @JvmStatic
    fun stringToDouble(value: String?): Double? {
        if (value == null) {
            return null
        }

        return value.toDouble()
    }
}