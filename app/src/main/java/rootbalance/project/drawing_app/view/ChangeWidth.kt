package rootbalance.project.drawing_app.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import rootbalance.project.drawing_app.MainViewModel
import rootbalance.project.drawing_app.OPTION_HEIGHT
import rootbalance.project.drawing_app.R

@Composable
fun ChangeWidth(
    modifier: Modifier,
    viewModel: MainViewModel,
) {
    var isChangeable by remember { mutableStateOf(false) }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        if (isChangeable) {
            ChangeOptionWidth(width = 3.dp, color = viewModel.color) { width ->
                viewModel.changeWidth(width)
                isChangeable = false
            }
            ChangeOptionWidth(width = 5.dp, color = viewModel.color) { width ->
                viewModel.changeWidth(width)
                isChangeable = false
            }
            ChangeOptionWidth(width = 10.dp, color = viewModel.color) { width ->
                viewModel.changeWidth(width)
                isChangeable = false
            }
            ChangeOptionWidth(width = 15.dp, color = viewModel.color) { width ->
                viewModel.changeWidth(width)
                isChangeable = false
            }
            ChangeOptionWidth(width = 20.dp, color = viewModel.color) { width ->
                viewModel.changeWidth(width)
                isChangeable = false
            }
        }
        Box(
            modifier =
                Modifier
                    .height(OPTION_HEIGHT.dp)
                    .clickable(
                        onClickLabel = (if (isChangeable) "close" else "open") + " line size change option",
                    ) { isChangeable = !isChangeable },
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_line_weight_24),
                contentDescription = "change stroke width",
            )
        }
    }
}

@Composable
fun ChangeOptionWidth(
    width: Dp,
    color: Color,
    onCLick: (width: Dp) -> Unit,
) {
    ChangeOption(
        modifier =
            Modifier.height(OPTION_HEIGHT.dp)
                .clickable(
                    onClickLabel = "change size to $width",
                ) { onCLick(width) },
        color = color,
        strokeWidth = width,
    )
}
