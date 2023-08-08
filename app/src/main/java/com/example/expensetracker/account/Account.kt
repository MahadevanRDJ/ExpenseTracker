package com.example.expensetracker.account

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.expensetracker.home.HomeViewModel

@Composable
fun Account(navHostController: NavHostController, homeViewModel: HomeViewModel) {
    AccountScreen(navHostController, homeViewModel)
}