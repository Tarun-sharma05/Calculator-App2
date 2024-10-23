package com.example.calculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.example.calculatorapp.ui.theme.CalculatorAppTheme
import com.example.calculatorapp.ui.theme.LightGray
import com.example.calculatorapp.ui.theme.MediumGray
import com.example.calculatorapp.ui.theme.Orange


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         enableEdgeToEdge()
        setContent {

            CalculatorAppTheme {
                val viewModel : CalculatorViewModel by viewModels()
                 val state = viewModel.state
                val buttonSpacing = 8.dp


//               Calculator(
//                   state = state,
//                   onAction = viewModel::onAction,
//                   modifier = Modifier
//                       .fillMaxSize()
//                       .background(MediumGray)
//                       .padding(16.dp)
//               )
                 Scaffold (modifier = Modifier.fillMaxSize()) { innerPadding ->

                     Box(modifier = Modifier.fillMaxSize().padding(innerPadding).background(MediumGray)) {
                         Column(
                             modifier = Modifier.fillMaxWidth()
                                 .align(Alignment.BottomCenter),
                             verticalArrangement = Arrangement.spacedBy(buttonSpacing)
                         ) {
                             Text(
                                 text = state.number1 + (state.operation?.symbol?: "") + state.number2,
                                 textAlign = TextAlign.End,
                                 modifier = Modifier.fillMaxWidth()
                                     .padding(vertical = 32.dp),
                                 fontWeight = FontWeight.Light,
                                 fontSize = 80.sp,
                                 color = Color.White,
                                 maxLines = 2


                             )

                             Row(
                                 modifier = Modifier.fillMaxWidth(),
                                 horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                             ) {
                                 CalculatorButton(symbol = "AC",
                                     modifier = Modifier
                                         .background(LightGray)
                                         .aspectRatio(2f)
                                         .weight(2f),
                                     onClick = {
                                         viewModel.onAction(CalculatorActions.Clear)
                                     }
                                 )

                                 CalculatorButton(symbol = "Del",
                                     modifier = Modifier
                                         .background(LightGray)
                                         .aspectRatio(1f)
                                         .weight(1f),
                                     onClick = {
                                         viewModel.onAction(CalculatorActions.Delete)
                                     }
                                 )

                                 CalculatorButton(symbol = "/",
                                     modifier = Modifier
                                         .background(Orange)
                                         .aspectRatio(1f)
                                         .weight(1f),
                                     onClick = {
                                         viewModel.onAction(
                                             CalculatorActions.Operation(
                                                 CalculatorOperations.Devision
                                             )
                                         )
                                     }
                                 )
                             }

                             Row(
                                 modifier = Modifier
                                     .fillMaxWidth(),
                                 horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                             ) {
                                 CalculatorButton(symbol = "9",
                                     modifier = Modifier
                                         .background(Color.DarkGray)
                                         .aspectRatio(1f)
                                         .weight(1f),
                                     onClick = {
                                         viewModel.onAction(CalculatorActions.Number(9))
                                     }
                                 )

                                 CalculatorButton(symbol = "8",
                                     modifier = Modifier
                                         .background(Color.DarkGray)
                                         .aspectRatio(1f)
                                         .weight(1f),
                                     onClick = {
                                         viewModel.onAction(CalculatorActions.Number(8))
                                     }
                                 )

                                 CalculatorButton(symbol = "7",
                                     modifier = Modifier
                                         .background(Color.DarkGray)
                                         .aspectRatio(1f)
                                         .weight(1f),
                                     onClick = {
                                         viewModel.onAction(CalculatorActions.Number(7))
                                     }
                                 )

                                 CalculatorButton(symbol = "X",
                                     modifier = Modifier
                                         .background(Orange)
                                         .aspectRatio(1f)
                                         .weight(1f),
                                     onClick = {
                                         viewModel.onAction(
                                             CalculatorActions.Operation(
                                                 CalculatorOperations.Multiplication
                                             )
                                         )
                                     }
                                 )

                             }

                             Row(
                                 modifier = Modifier
                                     .fillMaxWidth(),
                                 horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                             ) {
                                 CalculatorButton(symbol = "6",
                                     modifier = Modifier
                                         .background(Color.DarkGray)
                                         .aspectRatio(1f)
                                         .weight(1f),
                                     onClick = {
                                         viewModel.onAction(CalculatorActions.Number(6))
                                     }
                                 )
                                 CalculatorButton(symbol = "5",
                                     modifier = Modifier
                                         .background(Color.DarkGray)
                                         .aspectRatio(1f)
                                         .weight(1f),
                                     onClick = {
                                         viewModel.onAction(CalculatorActions.Number(5))
                                     }
                                 )

                                 CalculatorButton(symbol = "4",
                                     modifier = Modifier
                                         .background(Color.DarkGray)
                                         .aspectRatio(1f)
                                         .weight(1f),
                                     onClick = {
                                         viewModel.onAction(CalculatorActions.Number(4))
                                     }
                                 )

                                 CalculatorButton(symbol = "-",
                                     modifier = Modifier
                                         .background(Orange)
                                         .aspectRatio(1f)
                                         .weight(1f),
                                     onClick = {
                                         viewModel.onAction(
                                             CalculatorActions.Operation(
                                                 CalculatorOperations.Subtraction
                                             )
                                         )
                                     }
                                 )
                             }

                             Row(
                                 modifier = Modifier
                                     .fillMaxWidth(),
                                 horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                             ) {
                                 CalculatorButton(symbol = "3",
                                     modifier = Modifier
                                         .background(Color.DarkGray)
                                         .aspectRatio(1f)
                                         .weight(1f),
                                     onClick = {
                                         viewModel.onAction(CalculatorActions.Number(3))
                                     }
                                 )
                                 CalculatorButton(symbol = "2",
                                     modifier = Modifier
                                         .background(Color.DarkGray)
                                         .aspectRatio(1f)
                                         .weight(1f),
                                     onClick = {
                                         viewModel.onAction(CalculatorActions.Number(2))
                                     }
                                 )

                                 CalculatorButton(symbol = "1",
                                     modifier = Modifier
                                         .background(Color.DarkGray)
                                         .aspectRatio(1f)
                                         .weight(1f),
                                     onClick = {
                                         viewModel.onAction(CalculatorActions.Number(1))
                                     }
                                 )

                                 CalculatorButton(symbol = "+",
                                     modifier = Modifier
                                         .background(Orange)
                                         .aspectRatio(1f)
                                         .weight(1f),
                                     onClick = {
                                         viewModel.onAction(
                                             CalculatorActions.Operation(
                                                 CalculatorOperations.Add
                                             )
                                         )
                                     }
                                 )
                             }

                             Row(
                                 modifier = Modifier
                                     .fillMaxWidth(),
                                 horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                             ) {
                                 CalculatorButton(symbol = "0",
                                     modifier = Modifier
                                         .background(Color.DarkGray)
                                         .aspectRatio(2f)
                                         .weight(2f),
                                     onClick = {
                                         viewModel.onAction(CalculatorActions.Number(0))
                                     }
                                 )
                                 CalculatorButton(symbol = ".",
                                     modifier = Modifier
                                         .background(Color.DarkGray)
                                         .aspectRatio(1f)
                                         .weight(1f),
                                     onClick = {
                                         viewModel.onAction(CalculatorActions.Decimal)
                                     }
                                 )



                                 CalculatorButton(symbol = "=",
                                     modifier = Modifier
                                         .background(Orange)
                                         .aspectRatio(1f)
                                         .weight(1f),
                                     onClick = {
                                         viewModel.onAction(CalculatorActions.Calculate)
                                     }
                                 )
                             }


                         }
                     }
                 }


           }
            }
        }




}


