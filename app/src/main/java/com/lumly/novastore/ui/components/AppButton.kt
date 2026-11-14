package com.lumly.novastore.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lumly.novastore.ui.theme.NovastoreTheme

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    isPrimary: Boolean = true
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(size = 10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if(isPrimary) MaterialTheme.colorScheme.primary else
            Color.Transparent,
            contentColor = if(isPrimary) MaterialTheme.colorScheme.onPrimary else
            MaterialTheme.colorScheme.primary
        )
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 16.sp
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrimaryButtonPreview() {
    NovastoreTheme() {
        AppButton(label = "Continue",
            onClick = {},
            enabled = true,
            isPrimary = true)
    }
}

@Preview(showBackground = true)
@Composable
fun SecondaryButtonPreview() {
    NovastoreTheme() {
        AppButton(label = "Continue",
            onClick = {},
            enabled = true,
            isPrimary = false)
    }
}