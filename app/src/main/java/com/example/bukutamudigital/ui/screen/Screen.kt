package com.example.bukutamudigital.ui.screen

sealed class Screen(val route: String) {
    object Guest : Screen("guest")
    object Purpose : Screen("purpose")
    object Visit : Screen("visit")
    object Report : Screen("report")
}