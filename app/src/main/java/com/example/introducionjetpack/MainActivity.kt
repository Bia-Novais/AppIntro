package com.example.introducionjetpack

import android.app.Notification.Action
import android.os.Bundle
import android.os.Debug
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.introducionjetpack.ui.theme.DebugButtonColors
import com.example.introducionjetpack.ui.theme.ErrorButtonColors
import com.example.introducionjetpack.ui.theme.InfoButtonColors
import com.example.introducionjetpack.ui.theme.IntroducionJetPackTheme
import com.example.introducionjetpack.ui.theme.WarningButtonColors

const val TAG = "Teste Android"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroducionJetPackTheme {
                // A surface container using the 'background' color from the theme
                //chamada do método app
                App()
            }
        }
    }
}
//método
@Composable
fun App()
{
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (//posiciona os elementos dentro de colunas separadas

            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            //adiciona os elementos
            Greeting("Android")
            ActionButton(
                text = "Debug",
                buttonColors = DebugButtonColors(),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Log.d(TAG,"App clicou em Debug")
            }

            ActionButton(
                text = "Warning",
                buttonColors = WarningButtonColors(),
                modifier = Modifier.fillMaxWidth(0.7f)
            ){
                Log.d(TAG,"App clicou em Warning")
            }

            ActionButton(
                text = "Info",
                buttonColors = InfoButtonColors(),
                modifier = Modifier.fillMaxWidth(0.7f)
            ){
                Log.d(TAG,"App clicou em Info")
            }

            ActionButton(
                text = "Error",
                buttonColors = ErrorButtonColors(),
                modifier = Modifier.fillMaxWidth(0.7f)
            ){
                Log.d(TAG,"App clicou em Error")
            }
        }


        }

    }


@Preview(showBackground = true, widthDp = 150, heightDp = 200)
@Composable
fun AppPreview() {
    IntroducionJetPackTheme {
        App()
    }
}


@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit,
){
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier,
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun ActionButtonPreview(){
    ActionButton(text = "Cadastrar") {
        
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntroducionJetPackTheme {
        Greeting("Android")
    }
}