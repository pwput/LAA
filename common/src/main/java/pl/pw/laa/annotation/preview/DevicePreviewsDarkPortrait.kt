package pl.pw.laa.annotation.preview

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

private const val devicesDark = "DEVICES_DARK"


@Preview(
    name = "PIXEL_2_XL",
    group = devicesDark,
    device = Devices.PIXEL_2_XL,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "PIXEL_4",
    group = devicesDark,
    device = Devices.PIXEL_4,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Nexus_9",
    group = devicesDark,
    device = "spec:parent=Nexus 9,orientation=portrait",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Nexus_One",
    group = devicesDark,
    device = "id:Nexus One",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
annotation class DevicePreviewsDarkPortrait