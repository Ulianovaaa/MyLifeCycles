package com.izzzya.mylifecycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.izzzya.mylifecycles.classes.SharedPreferences

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SharedPreferences(this)


    }
}