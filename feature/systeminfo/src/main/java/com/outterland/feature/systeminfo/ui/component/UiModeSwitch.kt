package com.outterland.feature.systeminfo.ui.component

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.otterland.foundation.design.efects.UiModeState
import com.otterland.foundation.design.efects.changeUiMode
import com.otterland.foundation.design.efects.displayUiModeState

@Composable
fun UiModeSwitch(
    modifier: Modifier
){
    val uiMode = displayUiModeState()
    val context = LocalContext.current

    SingleChoiceSegmentedButtonRow(
        space = 2.dp,
        modifier = modifier
            .wrapContentWidth()
            .height(40.dp)
    ) {
        SegmentedButton(
            selected = uiMode == UiModeState.DAY,
            label = {
                Text(
                    text = "Day",
                    modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                    fontStyle = MaterialTheme.typography.labelLarge.fontStyle,
                    fontSize = MaterialTheme.typography.labelLarge.fontSize,
                    fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
                    fontWeight = MaterialTheme.typography.labelLarge.fontWeight,
                )
            },
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.5f),
            shape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp),
            onClick = {
                changeUiMode(
                    context = context,
                    uiMode = UiModeState.DAY
                )
            }
        )
        SegmentedButton(
            colors = SegmentedButtonDefaults.colors(

            ),
            selected = uiMode == UiModeState.AUTO,
            label = {
                Text(
                    text = "System",
                    modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                    fontStyle = MaterialTheme.typography.labelLarge.fontStyle,
                    fontSize = MaterialTheme.typography.labelLarge.fontSize,
                    fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
                    fontWeight = MaterialTheme.typography.labelLarge.fontWeight,
                )
            },
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.5f),
            shape = RectangleShape,
            onClick = {
                changeUiMode(
                    context = context,
                    uiMode = UiModeState.AUTO,
                )
            }
        )
        SegmentedButton(
            colors = SegmentedButtonDefaults.colors(

            ),
            selected = uiMode == UiModeState.NIGHT,
            label = {
                Text(
                    text = "Night",
                    modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                    fontStyle = MaterialTheme.typography.labelLarge.fontStyle,
                    fontSize = MaterialTheme.typography.labelLarge.fontSize,
                    fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
                    fontWeight = MaterialTheme.typography.labelLarge.fontWeight,
                )
            },
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.5f),
            shape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp),
            onClick = {
                changeUiMode(
                    context = context,
                    uiMode = UiModeState.NIGHT,
                )
            }
        )
    }
}