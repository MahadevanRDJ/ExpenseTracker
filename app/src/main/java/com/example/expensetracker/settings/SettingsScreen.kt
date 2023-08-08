package com.example.expensetracker.settings

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.expensetracker.home.AppBottomBar
import com.example.expensetracker.home.HomeViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(homeViewModel: HomeViewModel, navHostController: NavHostController) {
    Scaffold(
        bottomBar = { AppBottomBar(navController = navHostController, items = homeViewModel.screens ) }
    ) {

    }
}