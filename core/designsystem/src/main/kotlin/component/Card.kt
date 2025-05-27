package component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jm.designsystem.theme.ThinkUpTheme
import com.jm.designsystem.theme.ThemePreviews

@Composable
fun ThinkUpCard(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.surface,
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = color,
        shape = MaterialTheme.shapes.medium,
        content = content
    )
}

@Composable
fun ThinkUpCard(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    color: Color = MaterialTheme.colorScheme.surface,
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        enabled = enabled,
        color = color,
        shape = MaterialTheme.shapes.medium,
        content = content
    )
}

@ThemePreviews
@Composable
private fun ThinkUpCardPreview() {
    ThinkUpTheme {
        ThinkUpCard(modifier = Modifier.size(320.dp, 160.dp), content = {})
    }
}