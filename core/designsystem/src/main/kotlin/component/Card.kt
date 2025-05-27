package component

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jm.designsystem.theme.RoutineMemoTheme
import com.jm.designsystem.theme.ThemePreviews

@Composable
fun RMCard(
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
fun RMCard(
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
private fun RMCardPreview() {
    RoutineMemoTheme {
        RMCard(modifier = Modifier.size(320.dp, 160.dp), content = {})
    }
}