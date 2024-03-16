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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import rootbalance.project.drawing_app.MainViewModel
import rootbalance.project.drawing_app.OPTION_HEIGHT
import rootbalance.project.drawing_app.R

@Composable
fun ChangeWidth(modifier: Modifier, viewModel: MainViewModel) {
    var isChangeable by remember { mutableStateOf(false) }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        if (isChangeable) {
            ChangeOption(
                modifier = Modifier.height(OPTION_HEIGHT.dp)
                    .clickable {
                        viewModel.changeWidth(1.dp)
                        isChangeable = false
                    },
                color = viewModel.color,
                strokeWidth = 1.dp
            )
            ChangeOption(
                modifier = Modifier.height(OPTION_HEIGHT.dp)
                    .clickable {
                        viewModel.changeWidth(3.dp)
                        isChangeable = false
                    },
                color = viewModel.color,
                strokeWidth = 3.dp
            )
            ChangeOption(
                modifier = Modifier.height(OPTION_HEIGHT.dp)
                    .clickable {
                        viewModel.changeWidth(5.dp)
                        isChangeable = false
                    },
                color = viewModel.color,
                strokeWidth = 5.dp
            )
            ChangeOption(
                modifier = Modifier.height(OPTION_HEIGHT.dp)
                    .clickable {
                        viewModel.changeWidth(10.dp)
                        isChangeable = false
                    },
                color = viewModel.color,
                strokeWidth = 10.dp
            )
            ChangeOption(
                modifier = Modifier.height(OPTION_HEIGHT.dp)
                    .clickable {
                        viewModel.changeWidth(20.dp)
                        isChangeable = false
                    },
                color = viewModel.color,
                strokeWidth = 20.dp
            )
        }
        Box(
            modifier = Modifier.height(OPTION_HEIGHT.dp).clickable { isChangeable = !isChangeable },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_line_weight_24),
                contentDescription = "change stroke width"
            )
        }
    }
}