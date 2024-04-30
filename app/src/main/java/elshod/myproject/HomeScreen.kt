package elshod.myproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import elshod.myproject.sharedPreference.MyShared

@Composable
fun HomeScreen(navHostController: NavHostController) {

    val context = LocalContext.current
    val sharedPreferences = remember {
        MyShared(context)
    }
    val data = remember {
        mutableIntStateOf(sharedPreferences.getData("user_pin", 0))
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = data.intValue.toString(), style = TextStyle(fontSize = 20.sp, color = Color.Black))
    }
}