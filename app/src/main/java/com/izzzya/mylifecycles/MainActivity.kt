package com.izzzya.mylifecycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.izzzya.mylifecycles.classes.SharedPreferences

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SharedPreferences(this)

        //переключение онбординга
        val host = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val inflater = host.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph)
        if (SharedPreferences.getOnb() == true){
            graph.setStartDestination(R.id.calendarFragment)
        }else{
            graph.setStartDestination(R.id.onboardingFragment)
        }
        val navController = host.navController
        navController.setGraph(graph, intent.extras)

    }
}