package com.example.loginroomtest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginroomtest.ui.login.LoginScreen
import com.example.loginroomtest.ui.signup.SignupScreen

@Composable
fun NavigationManager() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.Login.route)
    {

        composable(
            route = NavigationRoutes.Login.route
        ){

            LoginScreen(
                onNewRegisterClick = {
                    navController.navigate(NavigationRoutes.SignUp.route)
                }
            )

        }

        composable(
            route = NavigationRoutes.SignUp.route
        ){

            SignupScreen()

        }

        composable(
            route = NavigationRoutes.Home.route
        ){

            //HomeScreen()

        }

    }

}