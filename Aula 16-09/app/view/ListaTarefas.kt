package com.example.app.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app.itemLista.ItemLista
import com.example.app.model.Tarefa
import com.example.app.ui.theme.Preto
import com.example.app.ui.theme.Purple40

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListaTarefas(
    navController: NavController
) {
    //Construcao da tela
    Scaffold (
        //Conteudo construcao do app
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Lista de Tarefas",
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
        },
        containerColor = Color.Black,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("AddTarefas")
                },
                containerColor = Purple40
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Icone de adicionar tarefa.",
                    tint = Color.White
                )
            }

        }
    ){
        val listaTarefas: MutableList<Tarefa> = mutableListOf(
            Tarefa(
                "IR embora",
                "Chamada please",
                2
            )
        )

        LazyColumn (
            modifier = Modifier.padding(0.dp, 100.dp, 0.dp, 0.dp)
        ) {
            itemsIndexed(listaTarefas) {
                position, _ -> ItemLista(position, listaTarefas)
            }
        }
    }
}

//@Preview
//@Composable
//fun ListaTarefasPreview() {
//    ListaTarefas(navController = rememberNavController())
//}