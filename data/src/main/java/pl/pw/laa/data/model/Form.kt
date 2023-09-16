package pl.pw.laa.data.model

enum class FormName {
    Isolated,
    Final,
    Medial,
    Initial,
}
sealed class Form(
    val char: Char,
) {
    abstract val name: FormName

    fun getName() = name.toString()
    override fun toString(): String {
        return this.char.toString()
    }
}

class Isolated(char: Char) : Form(char) {
    override val name: FormName = FormName.Isolated
}

class Final(char: Char) : Form(char) {
    override val name: FormName = FormName.Final
}

class Medial(char: Char) : Form(char) {
    override val name: FormName = FormName.Medial
}

class Initial(char: Char) : Form(char) {
    override val name: FormName = FormName.Initial
}
