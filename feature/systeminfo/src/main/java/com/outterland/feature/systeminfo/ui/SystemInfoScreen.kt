package com.outterland.feature.systeminfo.ui

import android.content.res.Configuration
import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.otterland.foundation.design.theme.OtterLandTheme
import com.outterland.feature.systeminfo.R

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
fun SystemInfoScreenPreview() {
    OtterLandTheme {
        SystemInfoScreen()
    }
}

enum class Category(
    val iconResourceId: Int
) {
    DEVICE_DETAILS(R.drawable.ic_cpu),
    HARDWARE(R.drawable.ic_cpu),
    DISPLAY(R.drawable.ic_display),
    NETWORK(R.drawable.ic_network),
    MEDIA_CODECS(R.drawable.ic_mediacodec),
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun SystemInfoScreen() {
    val cardColors =
        CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLow)
    val cardElevation = CardDefaults.elevatedCardElevation(defaultElevation = 1.dp)
    val cardShape = CardDefaults.elevatedShape

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
    ) {
        HardwareCard(
            cardColors = cardColors,
            carElevation = cardElevation,
            cardShape = cardShape,
        )
        HorizontalDivider(thickness = 8.dp, color = Color.Transparent)
        HardwareCard(
            cardColors = cardColors,
            carElevation = cardElevation,
            cardShape = cardShape,
        )
        HorizontalDivider(thickness = 8.dp, color = Color.Transparent)
        HardwareCard(
            cardColors = cardColors,
            carElevation = cardElevation,
            cardShape = cardShape,
        )
        HorizontalDivider(thickness = 8.dp, color = Color.Transparent)
        HardwareCard(
            cardColors = cardColors,
            carElevation = cardElevation,
            cardShape = cardShape,
        )
        HorizontalDivider(thickness = 8.dp, color = Color.Transparent)
        HardwareCard(
            cardColors = cardColors,
            carElevation = cardElevation,
            cardShape = cardShape,
        )
        HorizontalDivider(thickness = 8.dp, color = Color.Transparent)
        HardwareCard(
            cardColors = cardColors,
            carElevation = cardElevation,
            cardShape = cardShape,
        )
        HorizontalDivider(thickness = 8.dp, color = Color.Transparent)
        HardwareCard(
            cardColors = cardColors,
            carElevation = cardElevation,
            cardShape = cardShape,
        )
        HorizontalDivider(thickness = 8.dp, color = Color.Transparent)
        HardwareCard(
            cardColors = cardColors,
            carElevation = cardElevation,
            cardShape = cardShape,
        )
    }
}

@Composable
internal fun HardwareCard(
    cardColors: CardColors,
    carElevation: CardElevation,
    cardShape: Shape,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp),
        colors = cardColors,
        elevation = carElevation,
        shape = cardShape
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.image_processor),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f)
                    .graphicsLayer(alpha = 0.99f)
                    .drawWithContent {
                        drawContent()
                        drawRect(
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color.Black, Color.Transparent),
                                startX = size.width * 0.50f,
                                endX = size.width
                            ),
                            blendMode = BlendMode.DstIn
                        )
                    },
                contentScale = ContentScale.FillHeight,
                alignment = Alignment.CenterStart,
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 16.dp,
                        bottom = 16.dp,
                        end = 16.dp
                    )
            ) {
                Text(
                    text = "Hardware",
                    color = MaterialTheme.typography.titleMedium.color,
                    fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                    modifier = Modifier.wrapContentSize(),
                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                )
                HorizontalDivider(
                    color = Color.Transparent,
                    thickness = 8.dp
                )
                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Type:",
                        color = MaterialTheme.typography.bodySmall.color,
                        fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(0.5f),
                        fontSize = MaterialTheme.typography.bodySmall.fontSize
                    )
                    Text(
                        text = Build.HARDWARE,
                        color = MaterialTheme.typography.bodySmall.color,
                        fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(),
                        fontSize = MaterialTheme.typography.bodySmall.fontSize
                    )
                }

                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Core:",
                        color = MaterialTheme.typography.bodySmall.color,
                        fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(0.5f),
                        fontSize = MaterialTheme.typography.bodySmall.fontSize
                    )
                    Text(
                        text = "4",
                        color = MaterialTheme.typography.bodySmall.color,
                        fontFamily = MaterialTheme.typography.bodySmall.fontFamily,
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth(),
                        fontSize = MaterialTheme.typography.bodySmall.fontSize
                    )
                }
            }
        }
    }
}