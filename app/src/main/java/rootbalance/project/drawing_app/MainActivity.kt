package rootbalance.project.drawing_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.input.pointer.pointerInput
import rootbalance.project.drawing_app.ui.theme.DrawingAppTheme
import rootbalance.project.drawing_app.view.BottomContent
import rootbalance.project.drawing_app.view.Line

const val OPTION_HEIGHT = 48

class MainActivity : ComponentActivity() {
    private val viewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DrawingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        DrawingScreen(modifier = Modifier.fillMaxWidth().weight(1f), viewModel = viewModel)
                        BottomContent(modifier = Modifier.fillMaxWidth(), viewModel = viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun DrawingScreen(
    modifier: Modifier,
    viewModel: MainViewModel,
) {
    val lines = remember { viewModel.lines }
    Canvas(
        modifier = modifier
            .pointerInput(true) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    val line = Line(
                        start = change.position - dragAmount,
                        end = change.position,
                        color = viewModel.color,
                        strockWidth = viewModel.strockWidth
                    )
                    viewModel.addLine(line)
                }
            }) {
        lines.forEach { line ->
            drawLine(
                start = line.start,
                end = line.end,
                color = line.color,
                strokeWidth = line.strockWidth.toPx(),
                cap = StrokeCap.Round
            )
        }
    }
}