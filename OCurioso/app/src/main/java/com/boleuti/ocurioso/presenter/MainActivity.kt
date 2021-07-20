package com.boleuti.ocurioso.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class MainActivity : ComponentActivity() {


    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val curiosity = Curiosity(
            id = 1,
            listItemRenderInfo = listOf(
                ItemRenderInfo.ImageRender("https://miro.medium.com/max/2600/1*tDFPLaEDlaW5dtsfv4sd0A.png"),
                ItemRenderInfo.TitleRender("Quanto tempo a luz leva para ir do Sol até Plutão?"),
                ItemRenderInfo.BodyRender("A velocidade da luz é de 300.000 km/s. Se considerarmos a distância de 5.913 bilhões de quilômetros (622,42 anos-luz) que separa o Sol e Plutão, a luz leva cerca de cinco horas e 27 minutos para percorrer esse caminho - ou seja, mais ou menos o tempo de uma viagem de carro entre as cidades de São Paulo e Rio de Janeiro.")
            )
        )
        setContent {
            Column {
//                renderCuriosity(curiosity)
                Counter()
            }
        }
    }

    @Composable
    fun Counter() {

        val count = remember { mutableStateOf(0) }

        Button(onClick = { count.value++ }) {
            Text("I've been clicked ${count.value} times")
        }
    }
}