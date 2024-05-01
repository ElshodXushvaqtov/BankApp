package elshod.myproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import elshod.myproject.screens.AddCardScreen
import elshod.myproject.screens.CardsScreen
import elshod.myproject.screens.OtpView
import elshod.myproject.screens.SplashScreen


@Composable
fun Navigation(navHostController: NavHostController) {


    NavHost(navController = navHostController, startDestination = Screens.SplashScreen.route) {
        composable(route = Screens.SplashScreen.route) {
            SplashScreen(navHostController = navHostController)
        }

        composable(route = Screens.OTPScreen.route) {
            OtpView(navHostController = navHostController)
        }

        composable(route = Screens.CardsScreen.route) {
            CardsScreen(navHostController = navHostController)
        }

        composable(route = Screens.AddCardScreen.route) {
            AddCardScreen(navHostController = navHostController)
        }
    }

}