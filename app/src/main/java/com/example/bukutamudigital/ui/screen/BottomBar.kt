package com.example.bukutamudigital.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bukutamudigital.ui.screen.Screen

@Composable
fun BottomBar(navController: NavController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Button(onClick = {
            navController.navigate(Screen.Guest.route)
        }) {
            Text("Guest")
        }

        Button(onClick = {
            navController.navigate(Screen.Purpose.route)
        }) {
            Text("Purpose")
        }

        Button(onClick = {
            navController.navigate(Screen.Visit.route)
        }) {
            Text("Visit")
        }

        Button(onClick = {
            navController.navigate(Screen.Report.route)
        }) {
            Text("Report")
        }
    }
}