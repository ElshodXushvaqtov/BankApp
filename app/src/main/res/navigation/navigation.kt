package navigation

sealed class Screens(val route: String) {
    object SplashScreen : Screens("splash_screen")
    object OTPScreen : Screens("otp_screen")
}