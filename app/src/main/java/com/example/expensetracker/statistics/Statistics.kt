package com.example.expensetracker.statistics

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.expensetracker.home.HomeViewModel

@Composable
fun Statistics(navHostController: NavHostController, homeViewModel: HomeViewModel) {
    StatisticsScreen(homeViewModel, navHostController)
}

