package elshod.myproject.navigation

sealed class Screens(val route: String) {
    data object SplashScreen : Screens("splash_screen")
    data object OTPScreen : Screens("otp_screen")
    data object CardsScreen : Screens("cards_screen")
    data object AddCardScreen : Screens("addCard_screen")


}