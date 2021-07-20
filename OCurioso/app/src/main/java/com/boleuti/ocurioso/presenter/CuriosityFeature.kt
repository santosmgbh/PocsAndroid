package com.boleuti.ocurioso.presenter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.transform.RoundedCornersTransformation
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun renderCuriosity(curiosity: Curiosity) {
    val typography = MaterialTheme.typography
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        curiosity.listItemRenderInfo.forEach { itemRender ->
            when (itemRender) {
                is ItemRenderInfo.TitleRender -> {
                    Text(itemRender.text, style = typography.h4)
                }
                is ItemRenderInfo.BodyRender -> {
                    Text(
                        itemRender.text,
                        style = typography.body2
                    )
                }
                is ItemRenderInfo.ImageRender -> {
                    Image(
                        painter = rememberCoilPainter(
                            request = itemRender.url,
                            requestBuilder = {
                                transformations(RoundedCornersTransformation(4f))
                            }),
                        contentDescription = null,
                        modifier = Modifier
                            .height(180.dp)
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(4.dp))
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview
@Composable
fun previewHeader() {
    val curiosity = Curiosity(
        id = 1,
        listItemRenderInfo = listOf(
            ItemRenderInfo.TitleRender("Quanto tempo a luz leva para ir do Sol até Plutão?"),
            ItemRenderInfo.ImageRender("https://drive.google.com/file/d/1Yk9SupaMbSGwavfUSNIYJg47UYGv46Aj/view?usp=sharing"),
            ItemRenderInfo.BodyRender("A velocidade da luz é de 300.000 km/s. Se considerarmos a distância de 5.913 bilhões de quilômetros (622,42 anos-luz) que separa o Sol e Plutão, a luz leva cerca de cinco horas e 27 minutos para percorrer esse caminho - ou seja, mais ou menos o tempo de uma viagem de carro entre as cidades de São Paulo e Rio de Janeiro.")
        )
    )
    renderCuriosity(curiosity)
}

data class Curiosity(val id: Long, val listItemRenderInfo: List<ItemRenderInfo>)

sealed class ItemRenderInfo {
    data class TitleRender(val text: String) : ItemRenderInfo()
    data class BodyRender(val text: String) : ItemRenderInfo()
    data class ImageRender(val url: String) : ItemRenderInfo()
}