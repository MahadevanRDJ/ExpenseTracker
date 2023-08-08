package com.example.expensetracker.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun Home(navHostController: NavHostController, homeViewModel: HomeViewModel) {
    HomeScreen(navHostController, homeViewModel)
}

