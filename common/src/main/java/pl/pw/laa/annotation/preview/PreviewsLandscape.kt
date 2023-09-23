package pl.pw.laa.annotation.preview

import androidx.compose.ui.tooling.preview.Preview

private const val DEVICES_LANDSCAPE = "DEVICES_LANDSCAPE"
@Preview(
    name = "PIXEL_2_XL",
    group = DEVICES_LANDSCAPE,
    device = "spec:parent=pixel_2_xl,orientation=landscape",
)
@Preview(
    name = "PIXEL_4",
    group = DEVICES_LANDSCAPE,
    device = "spec:parent=pixel_4,orientation=landscape",
)
@Preview(
    name = "Nexus_9",
    group = DEVICES_LANDSCAPE,
    device = "spec:parent=Nexus 9",
)
@Preview(
    name = "Nexus_One",
    group = DEVICES_LANDSCAPE,
    device = "spec:parent=Nexus One,orientation=landscape",
)
annotation class PreviewsLandscape

