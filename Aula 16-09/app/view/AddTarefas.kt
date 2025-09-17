package com.example.app.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app.componentes.CaixaDeTexto
import com.example.app.ui.theme.Purple40
import com.example.app.ui.theme.Rb_Green
import com.example.app.ui.theme.Rb_Red
import com.example.app.ui.theme.Rb_Yellow

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddTarefas(
    navController: NavController
) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    "Adicionar Tarefa",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            },
            // cor do background do top bar
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Purple40
            )
        )
    }) {
        var tituloTarefa by remember {
            mutableStateOf("")
        }

        var descricaoTarefa by remember {
            mutableStateOf("")
        }

        var prioridade by remember {
            mutableStateOf("baixa")
        }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            CaixaDeTexto(
                //Fill max na horizontal
                Modifier.fillMaxWidth()
                    .padding(20.dp, 100.dp, 20.dp, 20.dp),
                tituloTarefa,
                {
                    tituloTarefa = it
                },
                "Titulo da Terafa",
                1,
                KeyboardType.Text
            )

            CaixaDeTexto(
                //Fill max na horizontal
                Modifier.fillMaxWidth()
                    .height(250.dp)
                    .padding(20.dp, 0.dp, 20.dp, 20.dp),
                descricaoTarefa,
                {
                    descricaoTarefa = it
                },
                "Descricao da Tarefa",
                5,
                KeyboardType.Text
            )

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ){
                Text("Prioridade:")

                //RadioButton prioridade baixa
                RadioButton(
                    selected = prioridade == "baixa",
                    onClick = {
                        prioridade = "baixa"
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Rb_Green
                    )
                )

                //RadioButton prioridade baixa
                RadioButton(
                    selected = prioridade == "media",
                    onClick = {
                        prioridade = "media"
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Rb_Yellow
                    )
                )

                //RadioButton prioridade baixa
                RadioButton(
                    selected = prioridade == "alta",
                    onClick = {
                        prioridade = "alta"
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Rb_Red
                    )
                )

            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                .padding(20.dp)
                .height(60.dp),
                colors = ButtonDefaults.buttonColors(Purple40),
                onClick = {}
            )  {
                Text("Adicionar")}

        }
    }
}

@Preview
@Composable
private fun AddTarefasPreview() {
    AddTarefas(navController = rememberNavController())
}