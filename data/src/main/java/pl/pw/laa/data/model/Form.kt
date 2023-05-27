package pl.pw.laa.data.model

enum class FormName(val value: String) {
    ISOLATED("Isolated"),
    FINAL("Final"),
    MEDIAL("Medial"),
    INITIAL("Initial"),
}

fun getAllFormNames() =
    listOf<FormName>(FormName.ISOLATED, FormName.FINAL, FormName.MEDIAL, FormName.INITIAL)

sealed class Form(
    val char: Char,
) {
    abstract val name: FormName
    override fun toString(): String {
        return this.char.toString()
    }
}

class Isolated(char: Char) : Form(char) {
    override val name: FormName = FormName.ISOLATED
}

class Final(char: Char) : Form(char) {
    override val name: FormName = FormName.FINAL
}

class Medial(char: Char) : Form(char) {
    override val name: FormName = FormName.MEDIAL
}

class Initial(char: Char) : Form(char) {
    override val name: FormName = FormName.INITIAL
}
