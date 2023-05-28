package pl.pw.laa.annotation.preview

import androidx.compose.ui.tooling.preview.Preview

private const val devicesLight = "DEVICES_LIGHT"
private const val devicesDark = "DEVICES_DARK"

@Preview(
    name = "PIXEL_4",
    group = devicesLight,
    device = "spec:parent=pixel_4,orientation=landscape",
    showSystemUi = true,
)
@Preview(
    name = "PIXEL_4_XL",
    group = devicesLight,
    device = "spec:parent=pixel_4_xl,orientation=landscape",
    showSystemUi = true,
)
@Preview(
    name = "Nexus_9",
    group = devicesLight,
    device = "spec:parent=Nexus 9",
    showSystemUi = true,
)
@Preview(
    name = "Nexus_One",
    group = devicesLight,
    device = "spec:parent=Nexus One,orientation=landscape",
    showSystemUi = true,
)
annotation class DevicePreviewsLightLandscape