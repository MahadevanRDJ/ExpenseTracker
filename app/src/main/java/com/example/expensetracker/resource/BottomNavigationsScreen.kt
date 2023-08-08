package com.example.expensetracker.resource

import androidx.annotation.StringRes
import com.example.expensetracker.R

sealed class BottomNavigationScreens(val route: String, @StringRes val resourceId: Int, val icon : Int) {
    object Home : BottomNavigationScreens("Home", R.string.home, R.drawable.home_24)
    object Account : BottomNavigationScreens("Account", R.string.account, R.drawable.account_balance_wallet_24)
    object Statistics : BottomNavigationScreens("Statistics", R.string.statistics,R.drawable.statistics_24 )
    object Settings : BottomNavigationScreens("Settings", R.string.settings, R.drawable.settings_24)
}
