package com.example.expensetracker.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.resource.BottomNavigationScreens
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme

@Composable
fun AppBottomBar(
    navController: NavHostController,
    items: List<BottomNavigationScreens>,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 0.dp
    ) {
        println(items)
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(painter = painterResource(id = screen.icon), contentDescription = screen.route) },
                label = { Text(stringResource(id = screen.resourceId)) },
                selected =  navBackStackEntry?.destination?.route == screen.route,
                onClick = {
                    println(navController)
                    println(screen)
                    println(screen.route)
                    navController.navigate(screen.route)
                },
                alwaysShowLabel = false,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BottomBarPreview() {
    ExpenseTrackerTheme() {
        AppBottomBar(navController = rememberNavController(), items = listOf(
            BottomNavigationScreens.Home,
            BottomNavigationScreens.Account,
            BottomNavigationScreens.Statistics,
            BottomNavigationScreens.Settings
        ))
    }
}