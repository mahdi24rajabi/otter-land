package com.outterland.feature.systeminfo.ui

import android.os.Build
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
internal fun SystemInfoScreen() {
    val cardColors =
        CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLow)
    val cardElevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp)
    val cardShape = CardDefaults.elevatedShape

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        SystemModelCard(
            cardColors = cardColors,
            carElevation = cardElevation,
            cardShape = cardShape,
            modifier = Modifier.fillMaxWidth()
        )
        HorizontalDivider(thickness = 8.dp, color = Color.Transparent)
        HardwareCard(
            cardColors = cardColors,
            carElevation = cardElevation,
            cardShape = cardShape,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
internal fun HardwareCard(
    cardColors: CardColors,
    carElevation: CardElevation,
    cardShape: Shape,
    modifier: Modifier
) {
    Card(
        modifier = modifier.wrapContentHeight(),
        colors = cardColors,
        elevation = carElevation,
        shape = cardShape
    ) {
        Column(
            modifier = modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(
                text = "Hardware",
                color = MaterialTheme.typography.titleMedium.color,
                fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                modifier = Modifier.wrapContentSize(),
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontStyle = MaterialTheme.typography.titleMedium.fontStyle
            )
            HorizontalDivider(
                color = Color.Transparent,
                thickness = 8.dp
            )
            Text(
                text = "Processor: ${Build.HARDWARE}",
                color = MaterialTheme.typography.bodySmall.color,
                fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                fontSize = MaterialTheme.typography.bodySmall.fontSize
            )
            Text(
                text = "Manufacturer: ${Build.MANUFACTURER}",
                color = MaterialTheme.typography.bodySmall.color,
                fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                fontSize = MaterialTheme.typography.bodySmall.fontSize
            )
            Text(
                text = "OS Version: ${Build.VERSION.RELEASE}",
                color = MaterialTheme.typography.bodySmall.color,
                fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                fontSize = MaterialTheme.typography.bodySmall.fontSize
            )


            Text(
                text = "Serial: ${Build.SERIAL}",
                color = MaterialTheme.typography.bodySmall.color,
                fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(0.5f),
                fontSize = MaterialTheme.typography.bodySmall.fontSize
            )
        }
    }
}

@Composable
internal fun SystemModelCard(
    cardColors: CardColors,
    carElevation: CardElevation,
    cardShape: Shape,
    modifier: Modifier
) {
    Card(
        modifier = modifier.wrapContentHeight(),
        colors = cardColors,
        elevation = carElevation,
        shape = cardShape
    ) {
        Column(
            modifier = modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(
                text = "Information",
                color = MaterialTheme.typography.titleMedium.color,
                fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                modifier = Modifier.wrapContentSize(),
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontStyle = MaterialTheme.typography.titleMedium.fontStyle
            )
            HorizontalDivider(
                color = Color.Transparent,
                thickness = 8.dp
            )
            Text(
                text = "Model: ${Build.BRAND}/${Build.MODEL}",
                color = MaterialTheme.typography.bodySmall.color,
                fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                fontSize = MaterialTheme.typography.bodySmall.fontSize
            )
            Text(
                text = "Manufacturer: ${Build.MANUFACTURER}",
                color = MaterialTheme.typography.bodySmall.color,
                fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                fontSize = MaterialTheme.typography.bodySmall.fontSize
            )
            Text(
                text = "OS Version: ${Build.VERSION.RELEASE}",
                color = MaterialTheme.typography.bodySmall.color,
                fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                fontSize = MaterialTheme.typography.bodySmall.fontSize
            )


            Text(
                text = "Serial: ${Build.SERIAL}",
                color = MaterialTheme.typography.bodySmall.color,
                fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(0.5f),
                fontSize = MaterialTheme.typography.bodySmall.fontSize
            )

        }
    }
}