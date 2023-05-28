package pl.pw.laa.annotation.preview

import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

private const val devicesLight = "DEVICES_LIGHT"
private const val devicesDark = "DEVICES_DARK"

@Preview(
    name = "PIXEL_4",
    group = devicesLight,
    device = Devices.PIXEL_4,
    showSystemUi = true,
)
@Preview(
    name = "PIXEL_4_XL",
    group = devicesLight,
    device = Devices.PIXEL_4_XL,
    showSystemUi = true,
)
@Preview(
    name = "Nexus_9",
    group = devicesLight,
    device = "spec:parent=Nexus 9,orientation=portrait",
    showSystemUi = true,
)
@Preview(
    name = "Nexus_One",
    group = devicesLight,
    device = "id:Nexus One",
    showSystemUi = true,
)
annotation class DevicePreviewsLightPortrait