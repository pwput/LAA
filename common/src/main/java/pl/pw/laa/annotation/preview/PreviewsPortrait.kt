package pl.pw.laa.annotation.preview

import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

private const val DEVICES_PORTRAIT = "DEVICES_PORTRAIT"


@Preview(
    name = "PIXEL_2_XL",
    group = DEVICES_PORTRAIT,
    device = Devices.PIXEL_2_XL,
)
@Preview(
    name = "PIXEL_4",
    group = DEVICES_PORTRAIT,
    device = Devices.PIXEL_4,
)
@Preview(
    name = "Nexus_9",
    group = DEVICES_PORTRAIT,
    device = "spec:parent=Nexus 9,orientation=portrait",
)
@Preview(
    name = "Nexus_One",
    group = DEVICES_PORTRAIT,
    device = "id:Nexus One",
)
annotation class PreviewsPortrait

