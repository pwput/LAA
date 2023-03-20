package pl.pw.laa.data

import pl.pw.laa.domain.LetterForm
import pl.pw.laa.domain.Letter

object Alphabet {
    val forms: List<String> = listOf(
        "name",
        "isolated",
        "initial",
        "medial",
        "final"
    )

    val letters: List<Letter> = listOf(
        // isolated initial medial final
        Letter(
            LetterForm(1, '\uFE8D'),
            LetterForm(2, '\uFE8D'),
            LetterForm(3, '\uFE8D'),
            LetterForm(4, '\uFE8E'),
            "alif",
            "TODO"
        ),
        Letter(
            LetterForm(5, '\uFE8F'),
            LetterForm(6, '\uFE91'),
            LetterForm(7, '\uFE92'),
            LetterForm(8, '\uFE90'),
            "ba",
            "TODO"
        ),
        Letter(
            LetterForm(9, '\uFE95'),
            LetterForm(10, '\uFE97'),
            LetterForm(11, '\uFE98'),
            LetterForm(12, '\uFE96'),
            "ta",
            "TODO"
        ),
        Letter(
            LetterForm(13, '\uFE99'),
            LetterForm(14, '\uFE9B'),
            LetterForm(15, '\uFE9C'),
            LetterForm(16, '\uFE9A'),
            "tha",
            "TODO"
        ),
        Letter(
            LetterForm(17, '\uFE9D'),
            LetterForm(18, '\uFE9F'),
            LetterForm(19, '\uFEA0'),
            LetterForm(20, '\uFE9E'),
            "jiim",
            "TODO"
        ),
        Letter(
            LetterForm(21, '\uFEA1'),
            LetterForm(22, '\uFEA3'),
            LetterForm(23, '\uFEA4'),
            LetterForm(24, '\uFEA2'),
            "hha",
            "TODO"
        ),
        Letter(
            LetterForm(25, '\uFEA5'),
            LetterForm(26, '\uFEA7'),
            LetterForm(27, '\uFEA8'),
            LetterForm(28, '\uFEA6'),
            "kha",
            "TODO"
        ),
        Letter(
            LetterForm(29, '\uFEA9'),
            LetterForm(30, '\uFEA9'),
            LetterForm(31, '\uFEAA'),
            LetterForm(32, '\uFEAA'),
            "daal",
            "TODO"
        ),
        Letter(
            LetterForm(33, '\uFEAB'),
            LetterForm(34, '\uFEAB'),
            LetterForm(35, '\uFEAC'),
            LetterForm(36, '\uFEAC'),
            "dhaal",
            "TODO"
        ),
        Letter(
            LetterForm(37, '\uFEAD'),
            LetterForm(38, '\uFEAD'),
            LetterForm(39, '\uFEAE'),
            LetterForm(43, '\uFEAE'),
            "ra",
            "TODO"
        ),
        Letter(
            LetterForm(41, '\uFEAF'),
            LetterForm(42, '\uFEAF'),
            LetterForm(43, '\uFEB0'),
            LetterForm(44, '\uFEB0'),
            "zay",
            "TODO"
        ),
        Letter(
            LetterForm(45, '\uFEB1'),
            LetterForm(46, '\uFEB3'),
            LetterForm(47, '\uFEB4'),
            LetterForm(48, '\uFEB2'),
            "siin",
            "TODO"
        ),
        Letter(
            LetterForm(49, '\uFEB5'),
            LetterForm(50, '\uFEB7'),
            LetterForm(51, '\uFEB8'),
            LetterForm(52, '\uFEB6'),
            "shiin",
            "TODO"
        ),
        Letter(
            LetterForm(53, '\uFEB9'),
            LetterForm(54, '\uFEBB'),
            LetterForm(55, '\uFEBC'),
            LetterForm(56, '\uFEBA'),
            "saad",
            "TODO"
        ),
        Letter(
            LetterForm(57, '\uFEBD'),
            LetterForm(58, '\uFEBF'),
            LetterForm(59, '\uFEC0'),
            LetterForm(60, '\uFEBE'),
            "daad",
            "TODO"
        ),
        Letter(
            LetterForm(61, '\uFEC1'),
            LetterForm(62, '\uFEC3'),
            LetterForm(63, '\uFEC4'),
            LetterForm(64, '\uFEC2'),
            "taa",
            "TODO"
        ),
        Letter(
            LetterForm(65, '\uFEC5'),
            LetterForm(66, '\uFEC7'),
            LetterForm(67, '\uFEC8'),
            LetterForm(68, '\uFEC6'),
            "za",
            "TODO"
        ),
        Letter(
            LetterForm(69, '\uFEC9'),
            LetterForm(70, '\uFECB'),
            LetterForm(71, '\uFECC'),
            LetterForm(72, '\uFECA'),
            "ayn",
            "TODO"
        ),
        Letter(
            LetterForm(73, '\uFECD'),
            LetterForm(74, '\uFECF'),
            LetterForm(75, '\uFED0'),
            LetterForm(76, '\uFECE'),
            "ghayn",
            "TODO"
        ),
        Letter(
            LetterForm(77, '\uFED1'),
            LetterForm(78, '\uFED3'),
            LetterForm(79, '\uFED4'),
            LetterForm(80, '\uFED2'),
            "fa",
            "TODO"
        ),
        Letter(
            LetterForm(81, '\uFED5'),
            LetterForm(82, '\uFED7'),
            LetterForm(83, '\uFED8'),
            LetterForm(84, '\uFED6'),
            "qaf",
            "TODO"
        ),
        Letter(
            LetterForm(85, '\uFED9'),
            LetterForm(86, '\uFEDB'),
            LetterForm(87, '\uFEDC'),
            LetterForm(88, '\uFEDA'),
            "kaf",
            "TODO"
        ),
        Letter(
            LetterForm(89, '\uFEDD'),
            LetterForm(90, '\uFEDF'),
            LetterForm(91, '\uFEE0'),
            LetterForm(92, '\uFEDE'),
            "lam",
            "TODO"
        ),
        Letter(
            LetterForm(93, '\uFEE1'),
            LetterForm(94, '\uFEE3'),
            LetterForm(95, '\uFEE4'),
            LetterForm(96, '\uFEE2'),
            "miim",
            "TODO"
        ),
        Letter(
            LetterForm(97, '\uFEE5'),
            LetterForm(98, '\uFEE7'),
            LetterForm(99, '\uFEE8'),
            LetterForm(100, '\uFEE6'),
            "nuun",
            "TODO"
        ),
        Letter(
            LetterForm(101, '\uFEE9'),
            LetterForm(102, '\uFEEB'),
            LetterForm(103, '\uFEEC'),
            LetterForm(104, '\uFEEA'),
            "ha",
            "TODO"
        ),
        Letter(
            LetterForm(105, '\uFEED'),
            LetterForm(106, '\uFEED'),
            LetterForm(107, '\uFEEE'),
            LetterForm(108, '\uFEEE'),
            "waw",
            "TODO"
        ),
        Letter(
            LetterForm(109, '\uFEF1'),
            LetterForm(110, '\uFEF3'),
            LetterForm(111, '\uFEF4'),
            LetterForm(112, '\uFEF2'),
            "ya",
            "TODO"
        )

    )
}
