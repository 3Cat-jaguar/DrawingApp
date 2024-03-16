package rootbalance.project.drawing_app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val lines: MutableList<Line> = mutableStateListOf()
    private val _color: MutableState<Color> = mutableStateOf(Color.Black)
    val color: Color
        get() = _color.value
    private val _strockWidth: MutableState<Dp> = mutableStateOf(1.dp)
    val strockWidth: Dp
        get() = _strockWidth.value

    fun deleteAllLines() {
        lines.clear()
    }
    fun changeColor(newColor: Color) {
        _color.value = newColor
    }
    fun changeWidth(newWidth: Dp) {
        _strockWidth.value = newWidth
    }
    fun addLine(line: Line) {
        lines.add(line)
    }

}