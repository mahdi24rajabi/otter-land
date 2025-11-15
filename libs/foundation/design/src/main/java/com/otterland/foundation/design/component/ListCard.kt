package com.otterland.foundation.design.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import kotlin.collections.forEachIndexed



@Composable
fun <T> ListCard(
    items: List<T>,
    cardColors: CardColors,
    carElevation: CardElevation,
    cardShape: Shape,
    listItemContent: @Composable (Int, T) -> Unit = {_, _ -> }
) {

    Card(
        colors = cardColors,
        elevation = carElevation,
        shape = cardShape,
        modifier = Modifier.wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(
                    top = 8.dp,
                    bottom = 8.dp
                )
        ) {
            items.forEachIndexed { index, item ->
                key(item) {
                    listItemContent(index, item)
                }
            }
        }
    }
}