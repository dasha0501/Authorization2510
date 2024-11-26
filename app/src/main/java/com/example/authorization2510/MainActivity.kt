package com.example.authorization2510

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.authorization2510.ui.theme.Authorization2510Theme
import com.example.authorization2510.ui.theme.PurpleGrey40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Authorization2510Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Preview
@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Box(
        modifier = with (Modifier){
            fillMaxSize()
                .paint(
                    // Replace with your image id
                    painterResource(id = R.drawable.image),
                    contentScale = ContentScale.FillBounds)




        }

    )

    Image(painter = painterResource(id = R.drawable.baseline_person_pin_24), contentDescription = "ee",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 160.dp)
            .size(width = 140.dp, height = 140.dp)
            .zIndex(1f))

    Card(
        colors = CardDefaults.cardColors(
            containerColor = PurpleGrey40,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 200.dp, start = 30.dp, end = 30.dp)
            .size(width = 200.dp, height = 400.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        EditNumberField(
            label = R.string.userName,
            leadingIcon = R.drawable.baseline_person_24,
            value = "",
            onValueChange = {},
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next


            ),


            modifier = Modifier
                .padding(top = 120.dp, start = 30.dp, end = 30.dp)
                .fillMaxWidth())

        EditNumberField(
            label = R.string.password,
            leadingIcon = R.drawable.baseline_lock_person_24,
            value = "",
            onValueChange = {},
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done


            ),
            modifier = Modifier
                .padding(top = 30.dp, start = 30.dp, end = 30.dp)
                .fillMaxWidth())


        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 30.dp, start = 30.dp, end = 30.dp),

        ){
            Button(onClick = { /*TODO*/ },
                shape = RectangleShape,
                modifier = Modifier
                    .size(height = 50.dp, width = 150.dp)
                    .padding(end = 30.dp),

                colors = ButtonDefaults.buttonColors(
                    contentColor = Color(0xFFFFFFFF),
                    containerColor = Color(0xFF000000))
            ) {

                Text(text = "Login")
                
            }

            Button(onClick = { /*TODO*/ },
                shape = RectangleShape,
                modifier = Modifier
                    .size(height = 50.dp, width = 120.dp)
                ,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color(0xFFFFFFFF),
                    containerColor = Color(0xFF000000))
            ) {

                Text(text = "Reset")

            }
        }

    }




    


}

@Composable
fun EditNumberField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier) {



    TextField(
        value = value,
        leadingIcon = { Icon(painterResource(id = leadingIcon), null) },
        onValueChange = onValueChange,
        label = {Text(stringResource(label))},
        singleLine = true,
        keyboardOptions = keyboardOptions,
        modifier = modifier
    )

}

