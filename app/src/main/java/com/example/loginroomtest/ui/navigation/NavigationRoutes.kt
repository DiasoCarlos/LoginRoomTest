package com.example.loginroomtest.ui.navigation

sealed class NavigationRoutes (val route : String) {

    object Login : NavigationRoutes(route = "Login")
    object SignUp : NavigationRoutes(route = "SignUp")
    object Home : NavigationRoutes(route = "Home")

}