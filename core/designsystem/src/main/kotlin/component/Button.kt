package component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.jm.designsystem.theme.RoutineMemoTheme
import com.jm.designsystem.theme.ThemePreviews

@Composable
fun RMButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    text: String,
    leadingIcon: ImageVector? = null
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onBackground,
        ),
        contentPadding = contentPadding,
    ) {
        RMButtonContent(text = text, leadingIcon = leadingIcon)
    }
}


@Composable
private fun RMButtonContent(
    text: String,
    leadingIcon: ImageVector? = null
) {
    if (leadingIcon != null) {
        Box(modifier = Modifier.sizeIn(maxHeight = ButtonDefaults.IconSize)) {
            Icon(imageVector = leadingIcon, contentDescription = null)
        }
    }
    Box(
        modifier = Modifier
            .padding(start = if (leadingIcon != null) ButtonDefaults.IconSpacing else 0.dp)
    ) {
        Text(text = text)
    }
}

@ThemePreviews
@Composable
private fun RMButtonPreview() {
    RoutineMemoTheme {
        RMButton(
            onClick = {},
            text = "TEST"
        )
    }
}

@ThemePreviews
@Composable
private fun RMButtonLeadingIconPreview() {
    RoutineMemoTheme {
        RMButton(
            onClick = {},
            text = "TEST",
            leadingIcon = Icons.Rounded.Add
        )
    }
}