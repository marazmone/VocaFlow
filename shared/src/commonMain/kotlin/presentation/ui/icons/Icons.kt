package presentation.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object IconArrowLeft {

    private var _vector: ImageVector? = null

    val icon: ImageVector
        get() {
            if (_vector != null) {
                return _vector!!
            }
            _vector = ImageVector.Builder(
                name = "vector",
                defaultWidth = 24.dp,
                defaultHeight = 27.dp,
                viewportWidth = 24f,
                viewportHeight = 27f
            ).apply {
                group {
                    path(
                        fill = SolidColor(Color(0xFF1C1C1E)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(13.83f, 19f)
                        curveTo(13.6806f, 19.0005f, 13.533f, 18.9676f, 13.398f, 18.9035f)
                        curveTo(13.263f, 18.8395f, 13.1441f, 18.7461f, 13.05f, 18.63f)
                        lineTo(8.22f, 12.63f)
                        curveTo(8.0729f, 12.4511f, 7.9925f, 12.2267f, 7.9925f, 11.995f)
                        curveTo(7.9925f, 11.7634f, 8.0729f, 11.539f, 8.22f, 11.36f)
                        lineTo(13.22f, 5.36003f)
                        curveTo(13.3897f, 5.1558f, 13.6337f, 5.0274f, 13.8981f, 5.003f)
                        curveTo(14.1625f, 4.9786f, 14.4258f, 5.0603f, 14.63f, 5.23f)
                        curveTo(14.8342f, 5.3998f, 14.9626f, 5.6437f, 14.987f, 5.9081f)
                        curveTo(15.0114f, 6.1725f, 14.9297f, 6.4358f, 14.76f, 6.64f)
                        lineTo(10.29f, 12f)
                        lineTo(14.61f, 17.36f)
                        curveTo(14.7323f, 17.5068f, 14.81f, 17.6856f, 14.8338f, 17.8751f)
                        curveTo(14.8577f, 18.0647f, 14.8268f, 18.2571f, 14.7447f, 18.4296f)
                        curveTo(14.6627f, 18.6021f, 14.5329f, 18.7475f, 14.3708f, 18.8486f)
                        curveTo(14.2087f, 18.9497f, 14.021f, 19.0023f, 13.83f, 19f)
                        close()
                    }
                }
            }.build()
            return _vector!!
        }
}
