package com.example.taxiapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.example.taxiapp.taxi.navigation.NavigateToScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val coroutineScope = rememberCoroutineScope()
            NavigateToScreen(navController = navController, coroutineScope = coroutineScope)
        }
    }
}