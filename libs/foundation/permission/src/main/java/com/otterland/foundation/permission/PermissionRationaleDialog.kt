package com.otterland.foundation.permission

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy

@Composable
fun PermissionRationaleDialog(
    title: String,
    reason: String,
    onApprove: () -> Unit,
    onDenied: () -> Unit,
) {
    Dialog(
        onDismissRequest = {
            onDenied()
        },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = true,
            decorFitsSystemWindows = true,
            securePolicy = SecureFlagPolicy.SecureOn
        )
    ) {
        Card(
            modifier = Modifier
                .wrapContentSize()
                .background(Color.Transparent),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
            ),
            shape = MaterialTheme.shapes.extraLarge,
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .wrapContentSize()
            ) {
                Text(
                    title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .wrapContentSize(),
                    fontFamily = MaterialTheme.typography.headlineSmall.fontFamily,
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    fontStyle = MaterialTheme.typography.headlineSmall.fontStyle,
                    fontWeight = MaterialTheme.typography.headlineSmall.fontWeight,
                )
                HorizontalDivider(
                    thickness = 16.dp,
                    color = Color.Transparent,
                    modifier = Modifier.wrapContentSize()
                )
                Text(
                    reason,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .wrapContentSize(),
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontStyle = MaterialTheme.typography.bodyMedium.fontStyle,
                    fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
                )
                HorizontalDivider(
                    thickness = 24.dp,
                    color = Color.Transparent,
                    modifier = Modifier.wrapContentSize()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    HorizontalDivider(
                        thickness = 24.dp,
                        color = Color.Transparent,
                        modifier = Modifier
                            .wrapContentSize()
                            .weight(1.0f)
                    )
                    TextButton(
                        onClick = {
                            onDenied()
                        },
                    ) {
                        Text(
                            text = "Cancel",
                            textAlign = TextAlign.Start,
                            modifier = Modifier.wrapContentSize(),
                            fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
                            fontSize = MaterialTheme.typography.labelLarge.fontSize,
                            fontStyle = MaterialTheme.typography.labelLarge.fontStyle,
                            fontWeight = MaterialTheme.typography.labelLarge.fontWeight,
                        )
                    }
                    TextButton(
                        onClick = {
                            onApprove()
                        },
                    ) {
                        Text(
                            text = "Accept",
                            textAlign = TextAlign.Start,
                            modifier = Modifier.wrapContentSize(),
                            fontFamily = MaterialTheme.typography.labelLarge.fontFamily,
                            fontSize = MaterialTheme.typography.labelLarge.fontSize,
                            fontStyle = MaterialTheme.typography.labelLarge.fontStyle,
                            fontWeight = MaterialTheme.typography.labelLarge.fontWeight,
                        )
                    }
                }
            }
        }
    }
}