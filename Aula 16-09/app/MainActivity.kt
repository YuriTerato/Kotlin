package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app.ui.theme.AppTheme
import com.example.app.view.AddTarefas
import com.example.app.view.ListaTarefas

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme{
                //
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    //Fala qual a primeira tela abrir o app, abrir em qual tela
                    startDestination = "ListaTarefas"
                ) {
                    //Cada Composable é uma tela, cada tela precisa ter uma rota. Como se fosse o get no endpoint/
                    composable(
                        route="ListaTarefas"
                    ) {
                        //Corpo da tela, executa a funcao que constroi a tela
                        ListaTarefas(navController)
                    }

                    composable(
                        route="AddTarefas"
                    ) {
                        AddTarefas(navController)
                    }
                }
            }
        }
    }
}