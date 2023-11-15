package com.izzzya.mylifecycles.classes

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.izzzya.mylifecycles.adapter.Pet
import java.lang.reflect.Type

class SharedPreferences(context: Context) {
    init {
        sharedPref = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)

    }

    companion object{
        private var sharedPref: SharedPreferences? = null
        const val PREFERENCES = "prefs"
        const val ONB_DONE = false
        const val CYCLE_LENGTH = 28
        const val PERIOD_LENGTH = 4

        //здесь хранить избранное
        private val PETS: String = ""

        fun <Pet> setList(list: List<Pet>){
            val json: String = Gson().toJson(list)
            val editor = sharedPref?.edit()
            editor?.putString(PETS, json)
            editor?.apply()
        }

        fun getList(): List<Pet> {
            val arrayItems: List<Pet>
            val serializedObject: String? = sharedPref?.getString(PETS, "")
            return if (!serializedObject.isNullOrEmpty()) {
                val gson = Gson()
                val type: Type = object : TypeToken<List<Pet?>?>() {}.type
                arrayItems = gson.fromJson<List<Pet>>(serializedObject, type)
                arrayItems
            } else listOf<Pet>()
        }

        fun setOnb(m: Boolean){
            sharedPref?.edit()
                ?.putBoolean("ONB_DONE", m)
                ?.apply()
        }

        fun getOnb(): Boolean{
            return sharedPref!!.getBoolean("ONB_DONE", false)
        }

        fun getCycle(): Int{
            return sharedPref!!.getInt("CYCLE_LENGTH", 28)
        }

        fun setCycle(c: Int){
            sharedPref?.edit()
                ?.putInt("CYCLE_LENGTH", c)
                ?.apply()
        }
        fun getPeriod(): Int{
            return sharedPref!!.getInt("PERIOD_LENGTH", 4)
        }

        fun setPeriod(c: Int){
            sharedPref?.edit()
                ?.putInt("PERIOD_LENGTH", c)
                ?.apply()
        }
    }

}