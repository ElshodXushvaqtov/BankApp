package elshod.myproject.navigation

sealed class Screens(val route: String) {
    data object SplashScreen : Screens("splash_screen")
    data object OTPScreen : Screens("otp_screen")

    data object HomeScreen : Screens("home_screen")

}