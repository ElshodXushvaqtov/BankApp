package elshod.myproject.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import elshod.myproject.R
import kotlinx.coroutines.delay

@SuppressLint("StaticFieldLeak")
lateinit var context: Context

@Composable
fun SplashScreen(navHostController: NavHostController) {
    val lottieComp by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.banksplash))
    val isPlaying by remember {
        mutableStateOf(true)
    }
    val progress by animateLottieCompositionAsState(composition = lottieComp, isPlaying = isPlaying)
    context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = lottieComp,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier.size(width = 200.dp, height = 200.dp)
        )
    }
    LaunchedEffect(key1 = progress) {
        delay(3500)
        navHostController.navigate("otp_screen")
    }
}