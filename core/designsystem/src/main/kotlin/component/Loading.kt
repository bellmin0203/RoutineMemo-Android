package component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ContainedLoadingIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.LoadingIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.graphics.shapes.RoundedPolygon
import com.jm.designsystem.theme.ThinkUpTheme
import com.jm.designsystem.theme.ThemePreviews

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun LoadingChip(
    modifier: Modifier = Modifier,
    color: Color = LoadingIndicatorDefaults.indicatorColor,
    polygons: List<RoundedPolygon> = LoadingIndicatorDefaults.DeterminateIndicatorPolygons
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LoadingIndicator(
            modifier = modifier,
            color = color,
            polygons = polygons
        )
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ContainedLoadingChip(
    modifier: Modifier = Modifier,
    containerColor: Color = LoadingIndicatorDefaults.containedContainerColor,
    indicatorColor: Color = LoadingIndicatorDefaults.indicatorColor,
    containerShape: Shape = LoadingIndicatorDefaults.containerShape
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ContainedLoadingIndicator(
            modifier = modifier,
            containerColor = containerColor,
            indicatorColor = indicatorColor,
            containerShape = containerShape
        )
    }
}

@ThemePreviews
@Composable
private fun LoadingChipPreview() {
    ThinkUpTheme {
        LoadingChip()
    }
}

@ThemePreviews
@Composable
private fun ContainedLoadingChipPreview() {
    ThinkUpTheme {
        ContainedLoadingChip()
    }
}