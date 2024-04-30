package elshod.myproject.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import elshod.myproject.sharedPreference.MyShared

@Composable
fun OtpView(navHostController: NavHostController) {
    var otpCode by remember {
        mutableStateOf("")
    }
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
        Text(text = "Please create a pin code:", style = TextStyle(fontSize = 20.sp))

        BasicTextField(
            value = otpCode,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                // This makes sure that we don't have more than 4 characters
                if (it.length <= 4) {
                    otpCode = it
                }
            })
        {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 100.dp)
            ) {
                repeat(4) { index ->
                    val number = when {
                        index >= otpCode.length -> ""
                        else -> otpCode[index]
                    }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = number.toString(),
                            style = MaterialTheme.typography.titleSmall
                        )

                        Box(
                            modifier = Modifier
                                .width(40.dp)
                                .height(2.dp)
                                .background(Color.Black)
                        )
                    }
                }
            }
        }
        OutlinedButton(
            onClick = {
                sharedPreferences.saveData("user_pin", otpCode.toInt())
                navHostController.navigate("home_screen")
            },
            modifier = Modifier
                .width(100.dp)
                .padding(top = 100.dp)
        ) {
            Text(text = "Create", style = TextStyle(color = Color.Black))

        }
    }
}