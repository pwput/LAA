package pl.pw.laa.domain

sealed class Form(
    val char: Char,
) {
    override fun toString(): String {
        return this.char.toString()
    }
}

class Isolated(char: Char) : Form(char)
class Final(char: Char) : Form(char)
class Medial(char: Char) : Form(char)
class Initial(char: Char) : Form(char)
