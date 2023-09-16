package pl.pw.laa.annotation.preview


import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

private const val devicesDark = "DEVICES_DARK"
@Preview(
    name = "PIXEL_2_XL",
    group = devicesDark,
    device = "spec:parent=pixel_2_xl,orientation=landscape",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "PIXEL_4",
    group = devicesDark,
    device = "spec:parent=pixel_4,orientation=landscape",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Nexus_9",
    group = devicesDark,
    device = "spec:parent=Nexus 9",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Nexus_One",
    group = devicesDark,
    device = "spec:parent=Nexus One,orientation=landscape",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
annotation class DevicePreviewsDarkLandscape
