package com.example.mycalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycalculator.ui.theme.MyCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyCalculator(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyCalculator(modifier: Modifier = Modifier) {

    var inputValue by remember { mutableStateOf("") }

    var resultDisplayed by remember { mutableStateOf("") }

    var resultUnchecked by remember { mutableDoubleStateOf(0.0) }

    val customTextStyleH1 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 28.sp
    )

    val customTextStyleInputValue = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 20.sp
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Calculator", style = customTextStyleH1/*, modifier  = Modifier.padding(8.dp)*/)

        Text(
            text = "$inputValue$resultDisplayed",
            style = customTextStyleInputValue,
            modifier = Modifier.padding(50.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = {
                inputValue = inputValue + "1"
            }) {
                Text("1")
            }
            Button(onClick = {
                inputValue = inputValue + "2"
            }) {
                Text("2")
            }
            Button(onClick = {
                inputValue = inputValue + "3"
            }) {
                Text("3")
            }
            Button(onClick = {
                inputValue = "$inputValue+"
            }) {
                Text("+")
            }
        }
        Row(

            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = {
                inputValue = inputValue + "4"
            }) {
                Text("4")
            }
            Button(onClick = {
                inputValue = inputValue + "5"
            }) {
                Text("5")
            }
            Button(onClick = {
                inputValue = inputValue + "6"
            }) {
                Text("6")
            }
            Button(onClick = {
                inputValue = "$inputValue-"
            }) {
                Text("-")
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = {
                inputValue = inputValue + "7"
            }) {
                Text("7")
            }
            Button(onClick = {
                inputValue = inputValue + "8"
            }) {
                Text("8")
            }
            Button(onClick = {
                inputValue = inputValue + "9"
            }) {
                Text("9")
            }
            Button(onClick = {
                inputValue = "$inputValue*"
            }) {
                Text("*")
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = {
                resultDisplayed = ""
                inputValue = ""
            }) {
                Text("C")
            }
            Button(onClick = {
                inputValue = inputValue + "0"
            }) {
                Text("0")
            }
            Button(onClick = {
                inputValue = "$inputValue="
                resultUnchecked = calculateExpression(inputValue)
                resultDisplayed = if (resultUnchecked == resultUnchecked.toInt().toDouble()){
                    resultUnchecked.toInt().toString()
                }else{
                    resultUnchecked.toString()
                }
            }) {
                Text("=")
            }
            Button(onClick = {
                inputValue = "$inputValue/"
            }) {
                Text("/")
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyCalculatorTheme {
        MyCalculator()
    }
}