package com.example.expensetracker.home

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Person
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.R
import com.example.expensetracker.ui.theme.ExpenseTrackerTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController,
               homeViewModel: HomeViewModel,
               modifier: Modifier = Modifier) {

    Scaffold(
        modifier.fillMaxSize(),
        bottomBar = {
            AppBottomBar(
                navController,
                homeViewModel.screens
            )
        }
    ) {
        Column(
            modifier.padding(18.dp),
        ) {
            TopHeader(modifier)
            Spacer()
            BalanceCard(modifier)
            Spacer()
            Operations(modifier)
            Spacer()
        }
        History(modifier)
    }
}


@Composable
fun Spacer(modifier: Modifier = Modifier) {
    Spacer(modifier = modifier.height(24.dp))
}

@Composable
fun Operations(modifier: Modifier) {
    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ActionBox(icon = R.drawable.expense_100, actionName = "Expense")
        ActionBox(icon = R.drawable.income_100, actionName = "Income")
        ActionBox(icon = R.drawable.cash_flow_100, actionName = "Transfer")
    }
}

@Composable
fun ActionBox(
    icon: Int,
    actionName: String,
    modifier: Modifier = Modifier,
    size: Int = 40,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier
                .border(width = 2.dp, color = Color.DarkGray, shape = ShapeDefaults.Large)
                .padding(12.dp)
                .height(size.dp)
                .width(size.dp)
        ) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier.matchParentSize()
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = actionName,
                )
            }
        }
        Spacer(modifier.height(6.dp))
        Text(
            text = actionName,
            style = TextStyle(
                fontSize = 12.sp
            )
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun History(modifier: Modifier) {

    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Expanded,
    )
    ModalBottomSheetLayout(
        sheetContent = { BottomSheetContent() },
        sheetState = bottomSheetState,
        sheetShape = ShapeDefaults.ExtraLarge ,
        scrimColor = Color.Transparent,
        modifier = modifier
    ) {

    }

}

@Composable
fun BottomSheetContent() {
    Surface(
        modifier = Modifier.height(350.dp),
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Divider(
                modifier = Modifier
                    .padding(vertical = 30.dp)
                    .padding(start = 140.dp, end = 140.dp)

            )
            Text(
                text = "Hello World",
                fontSize = 15.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Composable
fun BalanceCard(modifier: Modifier) {

    Card(
        modifier
            .height(200.dp)
            .fillMaxWidth(),
        shape = ShapeDefaults.ExtraLarge,

        ) {
        Column(
            modifier
                .fillMaxSize()
                .padding(start = 18.dp, end = 18.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Balance",
                color = Color.Gray,
                style = TextStyle(
                    fontSize = 18.sp,
                )
            )
            Text(
                text = "$1234",
                style = TextStyle(
                    fontSize = 32.sp
                )
            )
        }
    }
}

@Composable
fun TopHeader(modifier: Modifier) {
    Row(
        modifier.fillMaxWidth(),
    ) {
        Box(
            modifier
                .height(75.dp)
                .width(75.dp)
                .border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = ShapeDefaults.Large
                ),
            contentAlignment = Alignment.Center
        ) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier
                    .fillMaxSize()
                    .fillMaxWidth(),
            ) {
                Icon(
                    imageVector = Icons.TwoTone.Person,
                    contentDescription = "Profile",
                    modifier.matchParentSize()
                )
            }
        }
        Column(
            modifier.padding(start = 12.dp)
        ) {
            Text(
                text = "Krishna",
                style = TextStyle(
                    fontSize = 24.sp,
                )
            )
            Text(
                text = "1729",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Gray
                )
            )
        }
    }

}

@Composable
@Preview(showBackground = true)
fun HomePreview() {
    ExpenseTrackerTheme {
        Home(navHostController = rememberNavController(), homeViewModel = HomeViewModel())
    }
}