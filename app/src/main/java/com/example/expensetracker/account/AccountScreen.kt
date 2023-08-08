package com.example.expensetracker.account

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.expensetracker.home.AppBottomBar
import com.example.expensetracker.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AccountScreen(navHostController: NavHostController, homeViewModel: HomeViewModel) {
    Scaffold(
        bottomBar = { AppBottomBar(navController = navHostController, items = homeViewModel.screens ) }
    ) {

    }
}