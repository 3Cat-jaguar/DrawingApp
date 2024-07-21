package rootbalance.project.drawing_app.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import rootbalance.project.drawing_app.MainViewModel
import rootbalance.project.drawing_app.OPTION_HEIGHT

@Composable
fun ChangeColor(
    modifier: Modifier,
    viewModel: MainViewModel,
) {
    var isChangeable by remember { mutableStateOf(false) }
    val colorOptionHeight = 20.dp
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        if (isChangeable) {
            ChangeColorOption(color = Color.Black, colorOptionHeight = colorOptionHeight) { color ->
                viewModel.changeColor(color)
                isChangeable = false
            }
            ChangeColorOption(color = Color.Red, colorOptionHeight = colorOptionHeight) { color ->
                viewModel.changeColor(color)
                isChangeable = false
            }
            ChangeColorOption(color = Color.Blue, colorOptionHeight = colorOptionHeight) { color ->
                viewModel.changeColor(color)
                isChangeable = false
            }
            ChangeColorOption(color = Color.Green, colorOptionHeight = colorOptionHeight) { color ->
                viewModel.changeColor(color)
                isChangeable = false
            }
            ChangeColorOption(color = Color.White, colorOptionHeight = colorOptionHeight) { color ->
                viewModel.changeColor(color)
                isChangeable = false
            }
        }
        ChangeOption(
            modifier =
                Modifier
                    .height(OPTION_HEIGHT.dp)
                    .clickable(
                        onClickLabel = (if (isChangeable) "close" else "open") + " line color change option",
                    ) { isChangeable = !isChangeable },
            color = viewModel.color,
            strokeWidth = colorOptionHeight,
        )
    }
}

@Composable
fun ChangeColorOption(
    color: Color,
    colorOptionHeight: Dp,
    onClick: (color: Color) -> Unit,
) {
    ChangeOption(
        modifier =
            Modifier.height(OPTION_HEIGHT.dp)
                .clickable(
                    onClickLabel = "change color to white",
                ) { onClick(color) },
        color = color,
        strokeWidth = colorOptionHeight,
    )
}
