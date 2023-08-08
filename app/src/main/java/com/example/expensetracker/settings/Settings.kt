package com.example.expensetracker.settings

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.expensetracker.home.HomeViewModel

@Composable
fun Settings(navHostController: NavHostController, homeViewModel: HomeViewModel) {
    SettingsScreen(homeViewModel = homeViewModel, navHostController)
}