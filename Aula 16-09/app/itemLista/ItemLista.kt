package com.example.app.itemLista

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.model.Tarefa
import com.example.app.ui.theme.Rb_Green
import com.example.app.ui.theme.Rb_Red
import com.example.app.ui.theme.Rb_Yellow
import com.example.app.ui.theme.White

@Composable
fun ItemLista(
   position: Int,
   listaTarefas: MutableList<Tarefa>
) {
    val tituloTarefa = listaTarefas[position].tarefa
    val descricaoTarefa = listaTarefas[position].descricao
    val prioridade = listaTarefas[position].propriedade

    val nivelPrioridade: String = when(prioridade){
        0 -> "baixa"
        1 -> "media"
        2 -> "alta"
        else -> "baixa"
    }

    val corPrioridade = when(prioridade){
        0 -> Rb_Green
        1 -> Rb_Yellow
        2 -> Rb_Red
        else -> Rb_Green
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        colors = CardDefaults.cardColors(White)
    ) {
        Column (

        )
        {
            Text(
            tituloTarefa,
            modifier = Modifier
                .padding(20.dp),
            fontWeight = FontWeight.Bold
            )

        //Descricao TAREFA
        Text(
        descricaoTarefa,
            modifier = Modifier.padding(20.dp)
        )

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )   {
            Text("Prioridade:",
                modifier = Modifier.padding(0.dp, 0.dp, 20.dp, 0.dp)
            )

            Card (
                colors = CardDefaults.cardColors(corPrioridade)
            ){
                Box(
                    modifier = Modifier.padding(8.dp, 4.dp),
//                        contentAlignment = Alignment.Center
                ){
                    Text(
                        nivelPrioridade,
                        textAlign = TextAlign.Center
                    )
                }

                IconButton(
                        onClick = {},
                        modifier = Modifier.padding(100.dp, 0.dp, 0.dp, 0.dp )
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "Icone para apagar tarefa",
                            tint = Rb_Red
                        )
                    }
                }
            }
        }

    }
}