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

@ThreadLocal
object IconSuccess {

    private var _vector: ImageVector? = null

    val icon: ImageVector
        get() {
            if (_vector != null) {
                return _vector!!
            }
            _vector = ImageVector.Builder(
                name = "vector",
                defaultWidth = 65.dp,
                defaultHeight = 64.dp,
                viewportWidth = 65f,
                viewportHeight = 64f
            ).apply {
                group {
                    path(
                        fill = SolidColor(Color(0xFF1460F2)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(31.7932f, 5.94969f)
                        lineTo(30.3789f, 4.53544f)
                        curveTo(29.9884f, 4.1449f, 29.9884f, 3.5117f, 30.3789f, 3.1212f)
                        lineTo(31.7932f, 1.70694f)
                        curveTo(32.1837f, 1.3164f, 32.8169f, 1.3164f, 33.2074f, 1.7069f)
                        lineTo(34.6217f, 3.12119f)
                        curveTo(35.0122f, 3.5117f, 35.0122f, 4.1449f, 34.6217f, 4.5354f)
                        lineTo(33.2074f, 5.94969f)
                        curveTo(32.8168f, 6.3402f, 32.1837f, 6.3402f, 31.7932f, 5.9497f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFF1460F2)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(33.2074f, 58.0507f)
                        lineTo(34.6217f, 59.4649f)
                        curveTo(35.0122f, 59.8554f, 35.0122f, 60.4886f, 34.6217f, 60.8792f)
                        lineTo(33.2074f, 62.2934f)
                        curveTo(32.8169f, 62.6839f, 32.1838f, 62.6839f, 31.7932f, 62.2934f)
                        lineTo(30.3789f, 60.8792f)
                        curveTo(29.9884f, 60.4887f, 29.9884f, 59.8554f, 30.3789f, 59.4649f)
                        lineTo(31.7932f, 58.0507f)
                        curveTo(32.1837f, 57.6602f, 32.8168f, 57.6602f, 33.2074f, 58.0507f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFF646F)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(54.4057f, 36.5401f)
                        curveTo(54.9585f, 36.5401f, 55.4057f, 36.0929f, 55.4057f, 35.5401f)
                        verticalLineTo(29.4316f)
                        horizontalLineTo(56.3765f)
                        curveTo(56.9292f, 29.4316f, 57.3765f, 28.9844f, 57.3765f, 28.4316f)
                        curveTo(57.3765f, 27.8789f, 56.9292f, 27.4316f, 56.3765f, 27.4316f)
                        horizontalLineTo(52.4507f)
                        curveTo(51.898f, 27.4316f, 51.4507f, 27.8789f, 51.4507f, 28.4316f)
                        curveTo(51.4507f, 28.9844f, 51.898f, 29.4316f, 52.4507f, 29.4316f)
                        horizontalLineTo(53.4059f)
                        verticalLineTo(35.54f)
                        curveTo(53.4057f, 36.0928f, 53.853f, 36.5401f, 54.4057f, 36.5401f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFF646F)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(48.1127f, 27.4316f)
                        curveTo(48.1117f, 27.4316f, 48.1107f, 27.4316f, 48.1088f, 27.4316f)
                        curveTo(47.6352f, 27.4336f, 47.2143f, 27.7178f, 47.0297f, 28.1748f)
                        lineTo(44.3598f, 35.1835f)
                        curveTo(44.1636f, 35.7001f, 44.4223f, 36.2783f, 44.9379f, 36.4745f)
                        curveTo(45.0552f, 36.5194f, 45.1762f, 36.5399f, 45.2944f, 36.5399f)
                        curveTo(45.6968f, 36.5399f, 46.0767f, 36.2948f, 46.2291f, 35.8964f)
                        lineTo(46.6487f, 34.7949f)
                        horizontalLineTo(49.5572f)
                        lineTo(49.9713f, 35.8925f)
                        curveTo(50.1666f, 36.4101f, 50.7428f, 36.6709f, 51.2594f, 36.4755f)
                        curveTo(51.777f, 36.2803f, 52.0378f, 35.704f, 51.8424f, 35.1874f)
                        lineTo(49.1869f, 28.1504f)
                        curveTo(49.0072f, 27.7139f, 48.5853f, 27.4316f, 48.1127f, 27.4316f)
                        close()
                        moveTo(47.4104f, 32.795f)
                        lineTo(48.1098f, 30.9591f)
                        lineTo(48.8024f, 32.795f)
                        horizontalLineTo(47.4104f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFF646F)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(20.1017f, 27.4893f)
                        curveTo(19.6837f, 27.6201f, 19.3996f, 28.0069f, 19.3996f, 28.4444f)
                        verticalLineTo(35.5401f)
                        curveTo(19.3996f, 36.0929f, 19.8468f, 36.5401f, 20.3996f, 36.5401f)
                        curveTo(20.9523f, 36.5401f, 21.3996f, 36.0929f, 21.3996f, 35.5401f)
                        verticalLineTo(31.6524f)
                        lineTo(24.3732f, 35.958f)
                        curveTo(24.6622f, 36.3779f, 25.1447f, 36.5576f, 25.6086f, 36.4121f)
                        curveTo(26.0773f, 36.2656f, 26.3811f, 35.8301f, 26.3811f, 35.291f)
                        lineTo(26.3147f, 28.4219f)
                        curveTo(26.3098f, 27.873f, 25.8626f, 27.4316f, 25.3147f, 27.4316f)
                        curveTo(25.3118f, 27.4316f, 25.3078f, 27.4316f, 25.3049f, 27.4316f)
                        curveTo(24.7532f, 27.4375f, 24.3098f, 27.8886f, 24.3147f, 28.4414f)
                        lineTo(24.3528f, 32.4091f)
                        lineTo(21.2229f, 27.8759f)
                        curveTo(20.9738f, 27.5156f, 20.5197f, 27.3614f, 20.1017f, 27.4893f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFF646F)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(31.9729f, 29.4316f)
                        curveTo(32.4846f, 29.4316f, 32.9788f, 29.582f, 33.4006f, 29.8671f)
                        curveTo(33.8596f, 30.1748f, 34.4798f, 30.0546f, 34.7893f, 29.5976f)
                        curveTo(35.0979f, 29.1396f, 34.9778f, 28.5175f, 34.5198f, 28.209f)
                        curveTo(33.7659f, 27.7003f, 32.885f, 27.4316f, 31.9729f, 27.4316f)
                        curveTo(29.4611f, 27.4316f, 27.4183f, 29.4746f, 27.4183f, 31.9854f)
                        curveTo(27.4183f, 34.4971f, 29.4613f, 36.54f, 31.9729f, 36.54f)
                        curveTo(34.3684f, 36.54f, 36.0413f, 34.667f, 36.0413f, 31.9854f)
                        curveTo(36.0413f, 31.4326f, 35.594f, 30.9854f, 35.0413f, 30.9854f)
                        horizontalLineTo(32.9143f)
                        curveTo(32.3615f, 30.9854f, 31.9143f, 31.4326f, 31.9143f, 31.9854f)
                        curveTo(31.9143f, 32.5381f, 32.3615f, 32.9854f, 32.9143f, 32.9854f)
                        horizontalLineTo(33.9114f)
                        curveTo(33.6721f, 33.8419f, 33.0823f, 34.54f, 31.9729f, 34.54f)
                        curveTo(30.5646f, 34.54f, 29.4183f, 33.3935f, 29.4183f, 31.9854f)
                        curveTo(29.4183f, 30.5773f, 30.5646f, 29.4316f, 31.9729f, 29.4316f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFF646F)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(7.67188f, 35.5791f)
                        curveTo(7.8105f, 35.4551f, 7.9404f, 35.3204f, 8.0605f, 35.1768f)
                        curveTo(8.415f, 34.7529f, 8.3574f, 34.122f, 7.9335f, 33.7685f)
                        curveTo(7.5096f, 33.413f, 6.8779f, 33.4716f, 6.5252f, 33.8955f)
                        curveTo(6.4676f, 33.9649f, 6.4041f, 34.0293f, 6.3398f, 34.0869f)
                        curveTo(6.0019f, 34.3876f, 5.5702f, 34.54f, 5.0546f, 34.54f)
                        curveTo(3.6465f, 34.5401f, 2.5f, 33.3936f, 2.5f, 31.9854f)
                        curveTo(2.5f, 30.5771f, 3.6465f, 29.4316f, 5.0546f, 29.4316f)
                        curveTo(5.5664f, 29.4316f, 6.0595f, 29.582f, 6.4814f, 29.8663f)
                        curveTo(6.9384f, 30.1759f, 7.5615f, 30.0548f, 7.8691f, 29.5978f)
                        curveTo(8.1788f, 29.1408f, 8.0586f, 28.5186f, 7.6006f, 28.21f)
                        curveTo(6.8477f, 27.7003f, 5.9679f, 27.4316f, 5.0548f, 27.4316f)
                        curveTo(2.543f, 27.4316f, 0.5f, 29.4746f, 0.5f, 31.9854f)
                        curveTo(0.5f, 34.4971f, 2.543f, 36.54f, 5.0546f, 36.54f)
                        curveTo(6.0605f, 36.5401f, 6.9649f, 36.208f, 7.6719f, 35.5791f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFF646F)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(62.3247f, 31.1037f)
                        curveTo(61.4702f, 30.7883f, 60.6743f, 30.4454f, 60.4097f, 30.3303f)
                        curveTo(60.2769f, 30.216f, 60.2749f, 30.0647f, 60.2876f, 29.9797f)
                        curveTo(60.3022f, 29.8752f, 60.3793f, 29.6193f, 60.7739f, 29.5002f)
                        curveTo(61.7202f, 29.2179f, 62.6001f, 29.9113f, 62.6274f, 29.9328f)
                        curveTo(63.0513f, 30.2824f, 63.6763f, 30.2258f, 64.0308f, 29.8058f)
                        curveTo(64.3863f, 29.3829f, 64.3316f, 28.752f, 63.9087f, 28.3967f)
                        curveTo(63.8393f, 28.339f, 62.1948f, 26.9797f, 60.1978f, 27.5862f)
                        curveTo(59.1744f, 27.8938f, 58.4498f, 28.7024f, 58.3072f, 29.6955f)
                        curveTo(58.1734f, 30.6302f, 58.5787f, 31.5285f, 59.3648f, 32.0413f)
                        curveTo(59.4088f, 32.0697f, 59.4547f, 32.095f, 59.5034f, 32.1165f)
                        curveTo(59.5444f, 32.135f, 60.5269f, 32.5725f, 61.6333f, 32.9808f)
                        curveTo(61.8559f, 33.0628f, 62.5757f, 33.3655f, 62.4937f, 33.8235f)
                        curveTo(62.4409f, 34.1214f, 62.0542f, 34.5403f, 61.3618f, 34.5403f)
                        curveTo(60.6861f, 34.5403f, 60.0366f, 34.2688f, 59.6254f, 33.8147f)
                        curveTo(59.2543f, 33.4055f, 58.6216f, 33.3752f, 58.2123f, 33.7453f)
                        curveTo(57.8032f, 34.1164f, 57.7719f, 34.7482f, 58.1429f, 35.1584f)
                        curveTo(58.9388f, 36.0363f, 60.1117f, 36.5403f, 61.3617f, 36.5403f)
                        curveTo(62.9134f, 36.5403f, 64.2182f, 35.5452f, 64.4623f, 34.175f)
                        curveTo(64.6469f, 33.1399f, 64.1831f, 31.7893f, 62.3247f, 31.1037f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFF646F)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(43.1272f, 30.2798f)
                        curveTo(43.1272f, 28.7095f, 41.803f, 27.4321f, 40.1751f, 27.4321f)
                        horizontalLineTo(38.2855f)
                        curveTo(38.2855f, 27.4321f, 38.2854f, 27.4325f, 38.2852f, 27.4325f)
                        curveTo(38.2846f, 27.4325f, 38.2841f, 27.4321f, 38.2835f, 27.4321f)
                        curveTo(37.7307f, 27.4321f, 37.2835f, 27.8794f, 37.2835f, 28.4321f)
                        verticalLineTo(35.5405f)
                        curveTo(37.2835f, 36.0933f, 37.7307f, 36.5405f, 38.2835f, 36.5405f)
                        curveTo(38.8362f, 36.5405f, 39.2835f, 36.0933f, 39.2835f, 35.5405f)
                        verticalLineTo(33.8243f)
                        lineTo(41.3762f, 36.2018f)
                        curveTo(41.5745f, 36.4264f, 41.8499f, 36.5406f, 42.1272f, 36.5406f)
                        curveTo(42.3626f, 36.5406f, 42.598f, 36.4586f, 42.7884f, 36.2916f)
                        curveTo(43.2024f, 35.9264f, 43.2425f, 35.2945f, 42.8782f, 34.8795f)
                        lineTo(41.1766f, 32.9464f)
                        curveTo(42.3106f, 32.5485f, 43.1272f, 31.5086f, 43.1272f, 30.2798f)
                        close()
                        moveTo(40.1751f, 31.1264f)
                        curveTo(39.9661f, 31.1264f, 39.6272f, 31.1274f, 39.2932f, 31.1293f)
                        curveTo(39.2912f, 30.806f, 39.2884f, 29.432f, 39.2884f, 29.432f)
                        horizontalLineTo(40.1751f)
                        curveTo(40.6917f, 29.432f, 41.1272f, 29.8198f, 41.1272f, 30.2796f)
                        curveTo(41.1272f, 30.7388f, 40.6917f, 31.1264f, 40.1751f, 31.1264f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFF646F)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(9.10558f, 31.9854f)
                        curveTo(9.1056f, 34.4971f, 11.1486f, 36.54f, 13.6593f, 36.54f)
                        curveTo(16.1711f, 36.54f, 18.214f, 34.497f, 18.214f, 31.9854f)
                        curveTo(18.214f, 29.4746f, 16.171f, 27.4316f, 13.6593f, 27.4316f)
                        curveTo(11.1485f, 27.4316f, 9.1056f, 29.4746f, 9.1056f, 31.9854f)
                        close()
                        moveTo(16.214f, 31.9854f)
                        curveTo(16.214f, 33.3936f, 15.0675f, 34.54f, 13.6593f, 34.54f)
                        curveTo(12.2512f, 34.54f, 11.1056f, 33.3935f, 11.1056f, 31.9854f)
                        curveTo(11.1056f, 30.5771f, 12.2511f, 29.4316f, 13.6593f, 29.4316f)
                        curveTo(15.0676f, 29.4316f, 16.214f, 30.5773f, 16.214f, 31.9854f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFF1460F2)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(5.50005f, 25.0003f)
                        horizontalLineTo(59.5006f)
                        curveTo(60.0533f, 25.0003f, 60.5006f, 24.553f, 60.5006f, 24.0003f)
                        curveTo(60.5006f, 23.4475f, 60.0533f, 23.0003f, 59.5006f, 23.0003f)
                        horizontalLineTo(37.29f)
                        lineTo(44.3519f, 11.5245f)
                        curveTo(44.6409f, 11.0538f, 44.4946f, 10.4376f, 44.0248f, 10.1485f)
                        curveTo(43.5512f, 9.8585f, 42.9369f, 10.0059f, 42.6488f, 10.4756f)
                        lineTo(34.9413f, 23.0001f)
                        horizontalLineTo(33.5003f)
                        verticalLineTo(10f)
                        curveTo(33.5003f, 9.4473f, 33.0531f, 9f, 32.5003f, 9f)
                        curveTo(31.9476f, 9f, 31.5003f, 9.4473f, 31.5003f, 10f)
                        verticalLineTo(23.0001f)
                        horizontalLineTo(30.0592f)
                        lineTo(22.3517f, 10.4758f)
                        curveTo(22.0627f, 10.006f, 21.4475f, 9.8585f, 20.9757f, 10.1486f)
                        curveTo(20.5059f, 10.4376f, 20.3594f, 11.0539f, 20.6486f, 11.5246f)
                        lineTo(27.7105f, 23.0004f)
                        horizontalLineTo(5.50005f)
                        curveTo(4.9473f, 23.0004f, 4.5f, 23.4476f, 4.5f, 24.0004f)
                        curveTo(4.5f, 24.5532f, 4.9473f, 25.0003f, 5.5f, 25.0003f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFF646F)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(17.297f, 7.38351f)
                        lineTo(18.255f, 7.67063f)
                        lineTo(17.9679f, 8.62863f)
                        curveTo(17.8097f, 9.1579f, 18.1095f, 9.7155f, 18.6388f, 9.8738f)
                        curveTo(18.7345f, 9.9021f, 18.8312f, 9.9158f, 18.9259f, 9.9158f)
                        curveTo(19.3565f, 9.9158f, 19.754f, 9.6365f, 19.8839f, 9.2029f)
                        lineTo(20.171f, 8.24488f)
                        lineTo(21.129f, 8.53201f)
                        curveTo(21.2248f, 8.5604f, 21.3214f, 8.574f, 21.4162f, 8.574f)
                        curveTo(21.8468f, 8.574f, 22.2443f, 8.2948f, 22.3742f, 7.8611f)
                        curveTo(22.5324f, 7.3319f, 22.2325f, 6.7743f, 21.7033f, 6.616f)
                        lineTo(20.7453f, 6.32888f)
                        lineTo(21.0324f, 5.37088f)
                        curveTo(21.1907f, 4.8416f, 20.8908f, 4.284f, 20.3615f, 4.1258f)
                        curveTo(19.8293f, 3.9675f, 19.2747f, 4.2674f, 19.1164f, 4.7966f)
                        lineTo(18.8293f, 5.75463f)
                        lineTo(17.8713f, 5.46751f)
                        curveTo(17.34f, 5.3103f, 16.7844f, 5.6091f, 16.6262f, 6.1384f)
                        curveTo(16.4679f, 6.6676f, 16.7677f, 7.2253f, 17.297f, 7.3835f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFFE077)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(10.9757f, 14.6973f)
                        lineTo(20.9757f, 20.8515f)
                        curveTo(21.1397f, 20.9521f, 21.3205f, 21f, 21.4992f, 21f)
                        curveTo(21.8352f, 21f, 22.1632f, 20.831f, 22.3517f, 20.5244f)
                        curveTo(22.6407f, 20.0536f, 22.4943f, 19.4375f, 22.0246f, 19.1484f)
                        lineTo(12.0246f, 12.9941f)
                        curveTo(11.551f, 12.7041f, 10.9367f, 12.8506f, 10.6486f, 13.3213f)
                        curveTo(10.3595f, 13.7919f, 10.506f, 14.4081f, 10.9757f, 14.6973f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFF1460F2)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(8.50982f, 13f)
                        curveTo(9.0626f, 13f, 9.5098f, 12.5527f, 9.5098f, 12f)
                        curveTo(9.5098f, 11.4473f, 9.0626f, 11f, 8.5098f, 11f)
                        horizontalLineTo(8.50007f)
                        curveTo(7.9473f, 11f, 7.5049f, 11.4473f, 7.5049f, 12f)
                        curveTo(7.5049f, 12.5527f, 7.9571f, 13f, 8.5098f, 13f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFFE077)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(26.5715f, 11.3708f)
                        curveTo(26.7277f, 11.7624f, 27.1037f, 11.9997f, 27.5002f, 11.9997f)
                        curveTo(27.6242f, 11.9997f, 27.7502f, 11.9772f, 27.8714f, 11.9284f)
                        curveTo(28.3841f, 11.7233f, 28.6341f, 11.1413f, 28.429f, 10.6287f)
                        lineTo(26.429f, 5.62868f)
                        curveTo(26.2239f, 5.114f, 25.637f, 4.8669f, 25.1292f, 5.071f)
                        curveTo(24.6165f, 5.2762f, 24.3665f, 5.8582f, 24.5716f, 6.3708f)
                        lineTo(26.5715f, 11.3708f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFFEAA5)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(14.3633f, 11.707f)
                        curveTo(14.5586f, 11.9022f, 14.8145f, 12f, 15.0703f, 12f)
                        curveTo(15.3262f, 12f, 15.5821f, 11.9023f, 15.7774f, 11.707f)
                        curveTo(16.168f, 11.3163f, 16.168f, 10.6836f, 15.7774f, 10.293f)
                        lineTo(12.7774f, 7.29297f)
                        curveTo(12.3867f, 6.9023f, 11.754f, 6.9023f, 11.3633f, 7.293f)
                        curveTo(10.9727f, 7.6836f, 10.9727f, 8.3163f, 11.3633f, 8.707f)
                        lineTo(14.3633f, 11.707f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFFEAA5)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(8.55183f, 18.6835f)
                        curveTo(8.3771f, 19.2079f, 8.6602f, 19.7744f, 9.1837f, 19.9481f)
                        lineTo(12.1837f, 20.9481f)
                        curveTo(12.2892f, 20.9833f, 12.3956f, 20.9999f, 12.5001f, 20.9999f)
                        curveTo(12.9191f, 20.9999f, 13.3087f, 20.7353f, 13.4483f, 20.3163f)
                        curveTo(13.6231f, 19.7919f, 13.34f, 19.2254f, 12.8165f, 19.0516f)
                        lineTo(9.81645f, 18.0516f)
                        curveTo(9.2891f, 17.8769f, 8.7257f, 18.1601f, 8.5518f, 18.6835f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFF646F)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(43.5844f, 8.57401f)
                        curveTo(43.6792f, 8.574f, 43.7758f, 8.5604f, 43.8715f, 8.532f)
                        lineTo(44.8295f, 8.24488f)
                        lineTo(45.1167f, 9.20288f)
                        curveTo(45.2465f, 9.6365f, 45.644f, 9.9158f, 46.0747f, 9.9158f)
                        curveTo(46.1694f, 9.9158f, 46.266f, 9.9021f, 46.3618f, 9.8738f)
                        curveTo(46.891f, 9.7155f, 47.1909f, 9.1579f, 47.0327f, 8.6286f)
                        lineTo(46.7455f, 7.67063f)
                        lineTo(47.7035f, 7.38351f)
                        curveTo(48.2328f, 7.2253f, 48.5327f, 6.6676f, 48.3744f, 6.1384f)
                        curveTo(48.2162f, 5.6091f, 47.6585f, 5.3103f, 47.1293f, 5.4675f)
                        lineTo(46.1713f, 5.75463f)
                        lineTo(45.8842f, 4.79663f)
                        curveTo(45.725f, 4.2674f, 45.1703f, 3.9675f, 44.639f, 4.1258f)
                        curveTo(44.1098f, 4.284f, 43.8099f, 4.8416f, 43.9682f, 5.3709f)
                        lineTo(44.2553f, 6.32888f)
                        lineTo(43.2973f, 6.61601f)
                        curveTo(42.768f, 6.7743f, 42.4682f, 7.3319f, 42.6264f, 7.8611f)
                        curveTo(42.7563f, 8.2948f, 43.1537f, 8.574f, 43.5844f, 8.574f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFFE077)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(52.9759f, 12.9942f)
                        lineTo(42.9759f, 19.1485f)
                        curveTo(42.5062f, 19.4375f, 42.3597f, 20.0537f, 42.6488f, 20.5245f)
                        curveTo(42.8373f, 20.8311f, 43.1654f, 21.0001f, 43.5013f, 21.0001f)
                        curveTo(43.68f, 21.0001f, 43.8607f, 20.9522f, 44.0248f, 20.8516f)
                        lineTo(54.0248f, 14.6973f)
                        curveTo(54.4945f, 14.4083f, 54.641f, 13.7921f, 54.3519f, 13.3213f)
                        curveTo(54.0629f, 12.8506f, 53.4477f, 12.7041f, 52.9759f, 12.9942f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFF1460F2)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(56.4907f, 13f)
                        horizontalLineTo(56.5005f)
                        curveTo(57.0533f, 13f, 57.4957f, 12.5527f, 57.4957f, 12f)
                        curveTo(57.4957f, 11.4473f, 57.0435f, 11f, 56.4908f, 11f)
                        curveTo(55.938f, 11f, 55.4908f, 11.4473f, 55.4908f, 12f)
                        curveTo(55.4908f, 12.5527f, 55.938f, 13f, 56.4907f, 13f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFFE077)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(37.1292f, 11.9284f)
                        curveTo(37.2504f, 11.9772f, 37.3764f, 11.9996f, 37.5004f, 11.9996f)
                        curveTo(37.8969f, 11.9996f, 38.2729f, 11.7624f, 38.4291f, 11.3707f)
                        lineTo(40.4291f, 6.37073f)
                        curveTo(40.6342f, 5.858f, 40.3842f, 5.276f, 39.8715f, 5.071f)
                        curveTo(39.3627f, 4.8659f, 38.7767f, 5.114f, 38.5717f, 5.6286f)
                        lineTo(36.5717f, 10.6286f)
                        curveTo(36.3665f, 11.1412f, 36.6165f, 11.7234f, 37.1292f, 11.9284f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFFEAA5)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(49.9301f, 12f)
                        curveTo(50.186f, 12f, 50.4418f, 11.9023f, 50.6371f, 11.707f)
                        lineTo(53.6371f, 8.70697f)
                        curveTo(54.0277f, 8.3163f, 54.0277f, 7.6836f, 53.6371f, 7.293f)
                        curveTo(53.2465f, 6.9023f, 52.6136f, 6.9023f, 52.2231f, 7.293f)
                        lineTo(49.2231f, 10.293f)
                        curveTo(48.8325f, 10.6836f, 48.8325f, 11.3163f, 49.2231f, 11.707f)
                        curveTo(49.4183f, 11.9023f, 49.6742f, 12f, 49.9301f, 12f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFFEAA5)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(51.5522f, 20.3163f)
                        curveTo(51.6919f, 20.7353f, 52.0815f, 20.9999f, 52.5005f, 20.9999f)
                        curveTo(52.605f, 20.9999f, 52.7115f, 20.9833f, 52.8169f, 20.9481f)
                        lineTo(55.8169f, 19.9481f)
                        curveTo(56.3404f, 19.7743f, 56.6235f, 19.2079f, 56.4487f, 18.6835f)
                        curveTo(56.2749f, 18.16f, 55.7115f, 17.8769f, 55.1841f, 18.0516f)
                        lineTo(52.1841f, 19.0516f)
                        curveTo(51.6606f, 19.2254f, 51.3774f, 19.7918f, 51.5522f, 20.3163f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFF1460F2)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(59.5006f, 39f)
                        horizontalLineTo(5.50005f)
                        curveTo(4.9473f, 39f, 4.5f, 39.4473f, 4.5f, 40f)
                        curveTo(4.5f, 40.5528f, 4.9473f, 41f, 5.5f, 41f)
                        horizontalLineTo(27.7105f)
                        lineTo(20.6486f, 52.4758f)
                        curveTo(20.3596f, 52.9465f, 20.5059f, 53.5626f, 20.9757f, 53.8518f)
                        curveTo(21.1397f, 53.9524f, 21.3205f, 54.0003f, 21.4992f, 54.0003f)
                        curveTo(21.8352f, 54.0003f, 22.1632f, 53.8313f, 22.3517f, 53.5246f)
                        lineTo(30.0592f, 41.0001f)
                        horizontalLineTo(31.5003f)
                        verticalLineTo(54.0003f)
                        curveTo(31.5003f, 54.553f, 31.9476f, 55.0003f, 32.5003f, 55.0003f)
                        curveTo(33.0531f, 55.0003f, 33.5003f, 54.553f, 33.5003f, 54.0003f)
                        verticalLineTo(41.0001f)
                        horizontalLineTo(34.9415f)
                        lineTo(42.6489f, 53.5246f)
                        curveTo(42.8374f, 53.8313f, 43.1655f, 54.0003f, 43.5014f, 54.0003f)
                        curveTo(43.6802f, 54.0003f, 43.8608f, 53.9524f, 44.0249f, 53.8518f)
                        curveTo(44.4947f, 53.5628f, 44.6412f, 52.9465f, 44.3521f, 52.4758f)
                        lineTo(37.2901f, 41f)
                        horizontalLineTo(59.5006f)
                        curveTo(60.0533f, 41f, 60.5006f, 40.5528f, 60.5006f, 40f)
                        curveTo(60.5006f, 39.4473f, 60.0532f, 39f, 59.5006f, 39f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFF646F)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(47.7035f, 56.6165f)
                        lineTo(46.7455f, 56.3294f)
                        lineTo(47.0327f, 55.3714f)
                        curveTo(47.1909f, 54.8422f, 46.891f, 54.2845f, 46.3618f, 54.1263f)
                        curveTo(45.8315f, 53.969f, 45.2749f, 54.2689f, 45.1167f, 54.7972f)
                        lineTo(44.8295f, 55.7552f)
                        lineTo(43.8715f, 55.468f)
                        curveTo(43.3393f, 55.3098f, 42.7847f, 55.6097f, 42.6264f, 56.1389f)
                        curveTo(42.4682f, 56.6682f, 42.768f, 57.2258f, 43.2973f, 57.384f)
                        lineTo(44.2553f, 57.6712f)
                        lineTo(43.9682f, 58.6292f)
                        curveTo(43.8099f, 59.1584f, 44.1098f, 59.716f, 44.639f, 59.8743f)
                        curveTo(44.7348f, 59.9027f, 44.8314f, 59.9163f, 44.9262f, 59.9163f)
                        curveTo(45.3568f, 59.9163f, 45.7543f, 59.637f, 45.8842f, 59.2034f)
                        lineTo(46.1713f, 58.2454f)
                        lineTo(47.1293f, 58.5325f)
                        curveTo(47.225f, 58.5609f, 47.3217f, 58.5745f, 47.4164f, 58.5745f)
                        curveTo(47.847f, 58.5745f, 48.2445f, 58.2953f, 48.3744f, 57.8617f)
                        curveTo(48.5325f, 57.3323f, 48.2328f, 56.7747f, 47.7035f, 56.6165f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFFE077)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(54.0248f, 49.3029f)
                        lineTo(44.0248f, 43.1487f)
                        curveTo(43.5512f, 42.8577f, 42.9369f, 43.006f, 42.6488f, 43.4758f)
                        curveTo(42.3598f, 43.9465f, 42.5062f, 44.5627f, 42.9759f, 44.8518f)
                        lineTo(52.9759f, 51.006f)
                        curveTo(53.1399f, 51.1067f, 53.3207f, 51.1545f, 53.4994f, 51.1545f)
                        curveTo(53.8354f, 51.1545f, 54.1634f, 50.9855f, 54.3519f, 50.6789f)
                        curveTo(54.641f, 50.2082f, 54.4945f, 49.592f, 54.0248f, 49.3029f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFF1460F2)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(56.4907f, 51.0005f)
                        curveTo(55.9379f, 51.0005f, 55.4907f, 51.4477f, 55.4907f, 52.0005f)
                        curveTo(55.4907f, 52.5532f, 55.9379f, 53.0005f, 56.4907f, 53.0005f)
                        horizontalLineTo(56.5005f)
                        curveTo(57.0533f, 53.0005f, 57.4957f, 52.5532f, 57.4957f, 52.0005f)
                        curveTo(57.4957f, 51.4477f, 57.0434f, 51.0005f, 56.4907f, 51.0005f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFFE077)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(38.429f, 52.629f)
                        curveTo(38.2239f, 52.1153f, 37.637f, 51.8662f, 37.1292f, 52.0713f)
                        curveTo(36.6165f, 52.2765f, 36.3665f, 52.8585f, 36.5716f, 53.3711f)
                        lineTo(38.5716f, 58.3711f)
                        curveTo(38.7279f, 58.7627f, 39.1039f, 59f, 39.5004f, 59f)
                        curveTo(39.6244f, 59f, 39.7504f, 58.9775f, 39.8715f, 58.9287f)
                        curveTo(40.3842f, 58.7236f, 40.6342f, 58.1416f, 40.4291f, 57.629f)
                        lineTo(38.429f, 52.629f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFFEAA5)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(50.6371f, 52.2935f)
                        curveTo(50.2465f, 51.9028f, 49.6136f, 51.9028f, 49.2231f, 52.2935f)
                        curveTo(48.8326f, 52.6841f, 48.8325f, 53.3168f, 49.2231f, 53.7075f)
                        lineTo(52.2231f, 56.7075f)
                        curveTo(52.4183f, 56.9027f, 52.6742f, 57.0005f, 52.9301f, 57.0005f)
                        curveTo(53.186f, 57.0005f, 53.4418f, 56.9028f, 53.6371f, 56.7075f)
                        curveTo(54.0277f, 56.3168f, 54.0277f, 55.6841f, 53.6371f, 55.2935f)
                        lineTo(50.6371f, 52.2935f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFFEAA5)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(56.4486f, 45.3166f)
                        curveTo(56.6234f, 44.7922f, 56.3403f, 44.2257f, 55.8168f, 44.0519f)
                        lineTo(52.8168f, 43.0519f)
                        curveTo(52.2894f, 42.8752f, 51.7259f, 43.1603f, 51.5521f, 43.6838f)
                        curveTo(51.3774f, 44.2082f, 51.6605f, 44.7747f, 52.184f, 44.9484f)
                        lineTo(55.184f, 45.9484f)
                        curveTo(55.2895f, 45.9836f, 55.3959f, 46.0002f, 55.5004f, 46.0002f)
                        curveTo(55.9194f, 46.0002f, 56.309f, 45.7356f, 56.4486f, 45.3166f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFF646F)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(21.129f, 55.4681f)
                        lineTo(20.171f, 55.7552f)
                        lineTo(19.8839f, 54.7972f)
                        curveTo(19.7257f, 54.2688f, 19.168f, 53.969f, 18.6388f, 54.1263f)
                        curveTo(18.1095f, 54.2845f, 17.8097f, 54.8422f, 17.9679f, 55.3714f)
                        lineTo(18.255f, 56.3294f)
                        lineTo(17.297f, 56.6165f)
                        curveTo(16.7678f, 56.7748f, 16.4679f, 57.3324f, 16.6262f, 57.8617f)
                        curveTo(16.756f, 58.2953f, 17.1535f, 58.5745f, 17.5842f, 58.5745f)
                        curveTo(17.6789f, 58.5745f, 17.7755f, 58.5609f, 17.8713f, 58.5325f)
                        lineTo(18.8293f, 58.2454f)
                        lineTo(19.1164f, 59.2034f)
                        curveTo(19.2463f, 59.637f, 19.6438f, 59.9163f, 20.0744f, 59.9163f)
                        curveTo(20.1692f, 59.9163f, 20.2658f, 59.9027f, 20.3615f, 59.8743f)
                        curveTo(20.8908f, 59.7161f, 21.1907f, 59.1584f, 21.0324f, 58.6292f)
                        lineTo(20.7453f, 57.6712f)
                        lineTo(21.7033f, 57.384f)
                        curveTo(22.2325f, 57.2258f, 22.5324f, 56.6682f, 22.3742f, 56.1389f)
                        curveTo(22.215f, 55.6097f, 21.6603f, 55.3099f, 21.129f, 55.4681f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFFE077)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(12.0245f, 51.006f)
                        lineTo(22.0245f, 44.8518f)
                        curveTo(22.4942f, 44.5628f, 22.6407f, 43.9465f, 22.3516f, 43.4758f)
                        curveTo(22.0626f, 43.006f, 21.4473f, 42.8577f, 20.9756f, 43.1487f)
                        lineTo(10.9756f, 49.3029f)
                        curveTo(10.5058f, 49.5919f, 10.3593f, 50.2082f, 10.6485f, 50.6789f)
                        curveTo(10.837f, 50.9855f, 11.1651f, 51.1545f, 11.501f, 51.1545f)
                        curveTo(11.6797f, 51.1545f, 11.8605f, 51.1067f, 12.0245f, 51.006f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFF1460F2)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(8.50982f, 51.0005f)
                        horizontalLineTo(8.50007f)
                        curveTo(7.9473f, 51.0005f, 7.5049f, 51.4477f, 7.5049f, 52.0005f)
                        curveTo(7.5049f, 52.5532f, 7.9571f, 53.0005f, 8.5098f, 53.0005f)
                        curveTo(9.0626f, 53.0005f, 9.5098f, 52.5532f, 9.5098f, 52.0005f)
                        curveTo(9.5098f, 51.4477f, 9.0626f, 51.0005f, 8.5098f, 51.0005f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFFE077)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(27.8714f, 52.0713f)
                        curveTo(27.3616f, 51.8662f, 26.7766f, 52.1153f, 26.5716f, 52.629f)
                        lineTo(24.5716f, 57.629f)
                        curveTo(24.3665f, 58.1417f, 24.6165f, 58.7237f, 25.1292f, 58.9287f)
                        curveTo(25.2504f, 58.9776f, 25.3764f, 59f, 25.5004f, 59f)
                        curveTo(25.8969f, 59f, 26.2729f, 58.7627f, 26.4291f, 58.3711f)
                        lineTo(28.4291f, 53.3711f)
                        curveTo(28.634f, 52.8585f, 28.384f, 52.2765f, 27.8714f, 52.0713f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFFEAA5)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(14.3633f, 52.2935f)
                        lineTo(11.3633f, 55.2935f)
                        curveTo(10.9727f, 55.6841f, 10.9727f, 56.317f, 11.3633f, 56.7075f)
                        curveTo(11.5586f, 56.9027f, 11.8145f, 57.0005f, 12.0703f, 57.0005f)
                        curveTo(12.3262f, 57.0005f, 12.5821f, 56.9028f, 12.7774f, 56.7075f)
                        lineTo(15.7774f, 53.7075f)
                        curveTo(16.168f, 53.3168f, 16.168f, 52.6841f, 15.7774f, 52.2935f)
                        curveTo(15.3869f, 51.9028f, 14.754f, 51.9028f, 14.3633f, 52.2935f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFFEAA5)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(13.4483f, 43.6838f)
                        curveTo(13.2745f, 43.1603f, 12.713f, 42.8752f, 12.1837f, 43.0519f)
                        lineTo(9.1837f, 44.0519f)
                        curveTo(8.6602f, 44.2258f, 8.3771f, 44.7922f, 8.5518f, 45.3166f)
                        curveTo(8.6914f, 45.7356f, 9.0811f, 46.0002f, 9.5001f, 46.0002f)
                        curveTo(9.6046f, 46.0002f, 9.711f, 45.9836f, 9.8164f, 45.9484f)
                        lineTo(12.8165f, 44.9484f)
                        curveTo(13.34f, 44.7747f, 13.6231f, 44.2082f, 13.4483f, 43.6838f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFF646F)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(44.5004f, 25f)
                        horizontalLineTo(20.5002f)
                        curveTo(19.9479f, 25f, 19.5002f, 24.5523f, 19.5002f, 24f)
                        curveTo(19.5002f, 23.4478f, 19.9479f, 23f, 20.5002f, 23f)
                        horizontalLineTo(44.5004f)
                        curveTo(45.0527f, 23f, 45.5004f, 23.4478f, 45.5004f, 24f)
                        curveTo(45.5004f, 24.5523f, 45.0527f, 25f, 44.5004f, 25f)
                        close()
                    }
                    path(
                        fill = SolidColor(Color(0xFFFF646F)),
                        fillAlpha = 1.0f,
                        stroke = null,
                        strokeAlpha = 1.0f,
                        strokeLineWidth = 1.0f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Miter,
                        strokeLineMiter = 1.0f,
                        pathFillType = PathFillType.NonZero
                    ) {
                        moveTo(44.5004f, 41f)
                        horizontalLineTo(20.5002f)
                        curveTo(19.9479f, 41f, 19.5002f, 40.5523f, 19.5002f, 40f)
                        curveTo(19.5002f, 39.4478f, 19.9479f, 39f, 20.5002f, 39f)
                        horizontalLineTo(44.5004f)
                        curveTo(45.0527f, 39f, 45.5004f, 39.4478f, 45.5004f, 40f)
                        curveTo(45.5004f, 40.5524f, 45.0527f, 41f, 44.5004f, 41f)
                        close()
                    }
                }
            }.build()
            return _vector!!
        }
}
