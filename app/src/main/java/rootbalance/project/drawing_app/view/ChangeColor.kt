package rootbalance.project.drawing_app.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import rootbalance.project.drawing_app.MainViewModel
import rootbalance.project.drawing_app.OPTION_HEIGHT

@Composable
fun ChangeColor(modifier: Modifier, viewModel: MainViewModel) {
    var isChangeable by remember { mutableStateOf(false) }
    val colorOptionHeight = 10.dp
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        if (isChangeable) {
            ChangeOption(
                modifier = Modifier.height(OPTION_HEIGHT.dp)
                    .clickable(
                        onClickLabel = "change color to black"
                    ) {
                        viewModel.changeColor(Color.Black)
                        isChangeable = false
                    },
                color = Color.Black,
                strokeWidth = colorOptionHeight
            )
            ChangeOption(
                modifier = Modifier.height(OPTION_HEIGHT.dp)
                    .clickable(
                        onClickLabel = "change color to red"
                    ) {
                        viewModel.changeColor(Color.Red)
                        isChangeable = false
                    },
                color = Color.Red,
                strokeWidth = colorOptionHeight
            )
            ChangeOption(
                modifier = Modifier.height(OPTION_HEIGHT.dp)
                    .clickable(
                        onClickLabel = "change color to blue"
                    ) {
                        viewModel.changeColor(Color.Blue)
                        isChangeable = false
                    },
                color = Color.Blue,
                strokeWidth = colorOptionHeight
            )
            ChangeOption(
                modifier = Modifier.height(OPTION_HEIGHT.dp)
                    .clickable(
                        onClickLabel = "change color to green"
                    ) {
                        viewModel.changeColor(Color.Green)
                        isChangeable = false
                    },
                color = Color.Green,
                strokeWidth = colorOptionHeight
            )
            ChangeOption(
                modifier = Modifier.height(OPTION_HEIGHT.dp)
                    .clickable(
                        onClickLabel = "change color to white"
                    ) {
                        viewModel.changeColor(Color.White)
                        isChangeable = false
                    },
                color = Color.White,
                strokeWidth = colorOptionHeight
            )

        }
        ChangeOption(
            modifier = Modifier
                .height(OPTION_HEIGHT.dp)
                .clickable(
                    onClickLabel = (if (isChangeable) "close" else "open") + " line color change option"
                ) { isChangeable = !isChangeable },
            color = viewModel.color, strokeWidth = colorOptionHeight)
    }
}
