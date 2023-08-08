package com.example.expensetracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.account.Account
import com.example.expensetracker.home.Home
import com.example.expensetracker.home.HomeViewModel
import com.example.expensetracker.resource.BottomNavigationScreens
import com.example.expensetracker.settings.Settings
import com.example.expensetracker.statistics.Statistics


@Composable
fun ExpenseNavHost() {
    val navHostController = rememberNavController()
    val homeViewModel = HomeViewModel()

    NavHost(
        navController = navHostController,
        startDestination = BottomNavigationScreens.Home.route
    ) {
        composable(BottomNavigationScreens.Home.route) {
            Home(navHostController, homeViewModel)
        }
        composable(BottomNavigationScreens.Account.route) {
            Account(navHostController, homeViewModel)
        }
        composable(BottomNavigationScreens.Statistics.route) {
            Statistics(navHostController, homeViewModel)
        }
        composable(BottomNavigationScreens.Settings.route) {
            Settings(navHostController,homeViewModel)
        }
    }
}