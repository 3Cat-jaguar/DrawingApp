package rootbalance.project.drawing_app.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import rootbalance.project.drawing_app.MainViewModel
import rootbalance.project.drawing_app.OPTION_HEIGHT
import rootbalance.project.drawing_app.R

@Composable
fun BottomContent(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom,
    ) {
        ChangeColor(modifier = Modifier.weight(1f), viewModel = viewModel)
        ChangeWidth(modifier = Modifier.weight(1f), viewModel = viewModel)
        Box(
            modifier = Modifier.height(OPTION_HEIGHT.dp).weight(1f),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                modifier = Modifier.clickable { viewModel.undoLine() },
                painter = painterResource(id = R.drawable.outline_backspace_24),
                contentDescription = "clean canvas",
            )
        }
    }
}
