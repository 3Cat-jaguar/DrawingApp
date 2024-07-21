package rootbalance.project.drawing_app.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ChangeOption(
    modifier: Modifier,
    color: Color = Color.Black,
    strokeWidth: Dp = 1.dp,
) {
    val borderColor = if (color == Color.White) Color.Black else color
    Box(
        modifier =
            modifier
                .background(Color.White)
                .padding(vertical = 4.dp, horizontal = 20.dp),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier =
                Modifier
                    .size(strokeWidth)
                    .clip(CircleShape)
                    .border(color = borderColor, width = 1.dp, shape = CircleShape)
                    .background(color)
                    .semantics { contentDescription = "color $color, size $strokeWidth" },
        )
    }
}
