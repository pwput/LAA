package pl.pw.laa.preview


import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

private const val devicesLight = "DEVICES_LIGHT"
private const val devicesDark = "DEVICES_DARK"
@Preview(
    name = "PIXEL_2_XL",
    group = devicesDark,
    device = "spec:parent=pixel_2_xl,orientation=landscape",
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "PIXEL_4",
    group = devicesDark,
    device = "spec:parent=pixel_4,orientation=landscape",
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Nexus_9",
    group = devicesLight,
    device = "spec:parent=Nexus 9",
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Nexus_One",
    group = devicesDark,
    device = "spec:parent=Nexus One,orientation=landscape",
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
annotation class DevicePreviewsDarkLandscape
