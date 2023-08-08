package com.example.expensetracker.home

import androidx.lifecycle.ViewModel
import com.example.expensetracker.resource.BottomNavigationScreens

class HomeViewModel : ViewModel() {

    private val _bottomNavigation : List<BottomNavigationScreens> =  listOf(
        BottomNavigationScreens.Home,
        BottomNavigationScreens.Account,
        BottomNavigationScreens.Statistics,
        BottomNavigationScreens.Settings
    )

    val screens = _bottomNavigation

}