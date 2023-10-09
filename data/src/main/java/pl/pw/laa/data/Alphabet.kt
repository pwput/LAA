package pl.pw.laa.data

import pl.pw.laa.data.domain.Form
import pl.pw.laa.data.domain.Form.*
import pl.pw.laa.data.domain.Form.Initial
import pl.pw.laa.data.domain.Letter

object Alphabet {

    val letters: List<Letter> = listOf(
        Letter(
            Isolated('\uFE8D'),
            Final('\uFE8E'),
            Medial('\uFE8E'),
            Initial('\uFE8D'),
            "ʾalif",
            R.raw.r01alif,
        ),
        Letter(
            Isolated('\uFE8F'),
            Final('\uFE90'),
            Medial('\uFE92'),
            Initial('\uFE91'),
            "bāʾ",
            R.raw.r02ba,
        ),
        Letter(
            Isolated('\uFE95'),
            Final('\uFE96'),
            Medial('\uFE98'),
            Initial('\uFE97'),
            "tāʾ",
            R.raw.r03taa,
        ),
        Letter(
            Isolated('\uFE99'),
            Final('\uFE9A'),
            Medial('\uFE9C'),
            Initial('\uFE9B'),
            "thāʾ",
            R.raw.r04tha,
        ),
        Letter(
            Isolated('\uFE9D'),
            Final('\uFE9E'),
            Medial('\uFEA0'),
            Initial('\uFE9F'),
            "jīm",
            R.raw.r05jeem,
        ),
        Letter(
            Isolated('\uFEA1'),
            Final('\uFEA2'),
            Medial('\uFEA4'),
            Initial('\uFEA3'),
            "ḥāʾ",
            R.raw.r06haa,
        ),
        Letter(
            Isolated('\uFEA5'),
            Final('\uFEA6'),
            Medial('\uFEA8'),
            Initial('\uFEA7'),
            "khāʾ",
            R.raw.r07khaa,
        ),
        Letter(
            Isolated('\uFEA9'),
            Final('\uFEAA'),
            Medial('\uFEAA'),
            Initial('\uFEA9'),
            "dāl",
            R.raw.r08dal,
        ),
        Letter(
            Isolated('\uFEAB'),
            Final('\uFEAC'),
            Medial('\uFEAC'),
            Initial('\uFEAB'),
            "dhāl",
            R.raw.r09dhal,
        ),
        Letter(
            Isolated('\uFEAD'),
            Final('\uFEAE'),
            Medial('\uFEAE'),
            Initial('\uFEAD'),
            "rāʾ",
            R.raw.r10raa,
        ),
        Letter(
            Isolated('\uFEAF'),
            Final('\uFEB0'),
            Medial('\uFEB0'),
            Initial('\uFEAF'),
            "zāy",
            R.raw.r11jaa,
        ),
        Letter(
            Isolated('\uFEB1'),
            Final('\uFEB2'),
            Medial('\uFEB4'),
            Initial('\uFEB3'),
            "sīn",
            R.raw.r12seen,
        ),
        Letter(
            Isolated('\uFEB5'),
            Final('\uFEB6'),
            Medial('\uFEB8'),
            Initial('\uFEB7'),
            "shīn",
            R.raw.r13sheen,
        ),
        Letter(
            Isolated('\uFEB9'),
            Final('\uFEBA'),
            Medial('\uFEBC'),
            Initial('\uFEBB'),
            "ṣād",
            R.raw.r14saad,
        ),
        Letter(
            Isolated('\uFEBD'),
            Final('\uFEBE'),
            Medial('\uFEC0'),
            Initial('\uFEBF'),
            "ḍād",
            R.raw.r15dhaad,
        ),
        Letter(
            Isolated('\uFEC1'),
            Final('\uFEC2'),
            Medial('\uFEC4'),
            Initial('\uFEC3'),
            "ṭāʾ",
            R.raw.r16toa,
        ),
        Letter(
            Isolated('\uFEC5'),
            Final('\uFEC6'),
            Medial('\uFEC8'),
            Initial('\uFEC7'),
            "ẓāʾ",
            R.raw.r17dhaa,
        ),
        Letter(
            Isolated('\uFEC9'),
            Final('\uFECA'),
            Medial('\uFECC'),
            Initial('\uFECB'),
            "ʿayn",
            R.raw.r18ain,
        ),
        Letter(
            Isolated('\uFECD'),
            Final('\uFECE'),
            Medial('\uFED0'),
            Initial('\uFECF'),
            "ghayn",
            R.raw.r19ghain,
        ),
        Letter(
            Isolated('\uFED1'),
            Final('\uFED2'),
            Medial('\uFED4'),
            Initial('\uFED3'),
            "fāʾ",
            R.raw.r20faa,
        ),
        Letter(
            Isolated('\uFED5'),
            Final('\uFED6'),
            Medial('\uFED8'),
            Initial('\uFED7'),
            "qāf",
            R.raw.r21qaaf,
        ),
        Letter(
            Isolated('\uFED9'),
            Final('\uFEDA'),
            Medial('\uFEDC'),
            Initial('\uFEDB'),
            "kāf",
            R.raw.r22kaaf,
        ),
        Letter(
            Isolated('\uFEDD'),
            Final('\uFEDE'),
            Medial('\uFEE0'),
            Initial('\uFEDF'),
            "lām",
            R.raw.r23laam,
        ),
        Letter(
            Isolated('\uFEE1'),
            Final('\uFEE2'),
            Medial('\uFEE4'),
            Initial('\uFEE3'),
            "mīm",
            R.raw.r24meem,
        ),
        Letter(
            Isolated('\uFEE5'),
            Final('\uFEE6'),
            Medial('\uFEE8'),
            Initial('\uFEE7'),
            "nūn",
            R.raw.r25noon,
        ),
        Letter(
            Isolated('\uFEE9'),
            Final('\uFEEA'),
            Medial('\uFEEC'),
            Initial('\uFEEB'),
            "hāʾ",
            R.raw.r27ha,
        ),
        Letter(
            Isolated('\uFEED'),
            Final('\uFEEE'),
            Medial('\uFEEE'),
            Initial('\uFEED'),
            "wāw",
            R.raw.r26waw,
        ),
        Letter(
            Isolated('\uFEF1'),
            Final('\uFEF2'),
            Medial('\uFEF4'),
            Initial('\uFEF3'),
            "yāʾ",
            R.raw.r29yaa,
        ),

    )

    fun getLetterName(form: Form) = letters.first{it.hasForm(form)}.name

}
