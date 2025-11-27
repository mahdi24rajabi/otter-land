package com.otterland.foundation.design.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.otterland.foundation.design.R

@Composable
fun SingleLineListItem(
    iconResource: Int,
    label: String,
    expandable: Boolean,
    onExpand: () -> Unit,
) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxWidth()
            .height(56.dp)
            .padding(
                start = 16.dp, end = 16.dp,
                top = 8.dp, bottom = 8.dp,
            )
            .clickable(expandable) {
                onExpand()
            },
    ) {
        Icon(
            painter = painterResource(iconResource),
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterVertically)
        )
        VerticalDivider(thickness = 16.dp, color = Color.Transparent)
        Text(
            text = label,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1.0f),
            fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
            fontWeight = MaterialTheme.typography.bodyLarge.fontWeight,
        )
        VerticalDivider(
            thickness = 16.dp,
            color = Color.Transparent,
        )
        if (expandable) {
            Icon(
                painter = painterResource(R.drawable.ic_right_arrow),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}