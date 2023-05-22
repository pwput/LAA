import android.content.res.Configuration
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

@Preview(
    name = "PIXEL_2_XL",
    group = devicesDark,
    device = Devices.PIXEL_2_XL,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "PIXEL_4",
    group = devicesDark,
    device = Devices.PIXEL_4,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Nexus_9",
    group = devicesLight,
    device = "spec:parent=Nexus 9,orientation=portrait",
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Nexus_One",
    group = devicesDark,
    device = "id:Nexus One",
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
annotation class DevicePreviewsDarkPortrait

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
