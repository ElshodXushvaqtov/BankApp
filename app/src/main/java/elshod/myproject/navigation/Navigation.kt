package elshod.myproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import elshod.myproject.HomeScreen
import elshod.myproject.screens.OtpView
import elshod.myproject.screens.SplashScreen


@Composable
fun Navigation(navController: NavHostController) {


    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(route = Screens.SplashScreen.route) {
            SplashScreen(navHostController = navController)
        }

        composable(route = Screens.OTPScreen.route) {
            OtpView(navHostController = navController)
        }

        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navHostController = navController)
        }
    }

}