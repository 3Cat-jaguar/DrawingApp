package rootbalance.project.drawing_app.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ChangeOption(modifier: Modifier, color: Color = Color.Black, strokeWidth: Dp = 1.dp) {
    val borderColor = if (color == Color.White) Color.Black else color
    Box(
        modifier = modifier
            .background(Color.White)
            .padding(vertical = 4.dp, horizontal = 20.dp),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(strokeWidth)
                .background(color)
                .border(color = borderColor, width = 1.dp)
                .semantics { contentDescription = "color $color, size $strokeWidth" }
        )
    }
}