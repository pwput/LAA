package pl.pw.laa.presentation.quiz

import de.palm.composestateevents.StateEventWithContent
import de.palm.composestateevents.consumed
import pl.pw.laa.data.Alphabet
import pl.pw.laa.data.domain.Final
import pl.pw.laa.data.domain.Form
import pl.pw.laa.data.domain.Initial
import pl.pw.laa.data.domain.Isolated
import pl.pw.laa.data.domain.Letter
import pl.pw.laa.data.domain.Medial
import pl.pw.laa.state.BaseState
import pl.pw.laa.state.UserPreferencesState
import pl.pw.laa.state.ISnackbarEventStateWithContent
import timber.log.Timber
import kotlin.random.Random
import kotlin.random.nextInt

private const val NumnerOfQuestions = 2

data class QuizState(
    var score: Int = 0,
    val mistakes: Int = 0,
    val currentQuestionIndex: Int = 0,
    val questions: List<SingleQuestion> = mutableListOf(),
    val preferences: UserPreferencesState = UserPreferencesState(),
    var isDialogVisible: Boolean = false,
    override val showSnackbarEvent: StateEventWithContent<Array<String>> = consumed(),
    private val availableForms: MutableList<Class<out Form>> = mutableListOf()
) : BaseState(), ISnackbarEventStateWithContent {

    fun currentQuestion() =
        if (currentQuestionIndex > questions.lastIndex)
            questions.last()
        else
            questions[currentQuestionIndex]

    fun isCurrentQuestionLast() = currentQuestionIndex == questions.size - 1

    fun resetState(): QuizState {
        setupAvailableForms()
        val newQuestions = getNewQuestions()
        return this.copy(
            score = 0,
            mistakes = 0,
            currentQuestionIndex = 0,
            questions = newQuestions,
            isDialogVisible = false,
            showSnackbarEvent = consumed()
        )
    }

    private fun getNewQuestions(): List<SingleQuestion> {
        val newQuestions = mutableListOf<SingleQuestion>()
        for (i in 0 until NumnerOfQuestions) {
            val letters = getRandomLetters()
            val forms = letters.map {
                it.getForm(availableForms.random())
            }
            newQuestions.add(
                SingleQuestion(
                    rightAnswer = getRandomLetter(letters),
                    forms = forms
                )
            )
        }
        return newQuestions
    }

    private fun getRandomLetters(): List<Letter> {
        return  generateLetterList(
            generateSequence(
                Alphabet.letters.size - 1,
                preferences.answersCount
            ))
    }

    private fun setupAvailableForms() {
        Timber.d("Setting up available forms")
        val availableForms = mutableListOf<Class<out Form>>()
        if (preferences.isInitialTested) availableForms.add(Initial::class.java)
        if (preferences.isMedialTested) availableForms.add(Medial::class.java)
        if (preferences.isFinalTested) availableForms.add(Final::class.java)
        if (preferences.isIsolatedTested) availableForms.add(Isolated::class.java)
        if (availableForms.size == 0) Timber.d("No available forms, you have a big problem!!")
        this.availableForms.clear()
        this.availableForms.addAll(availableForms)
    }

    private fun getRandomLetter(list: List<Letter>) = list[Random.nextInt(list.indices)]

    private fun generateLetterList(set: Set<Int>): List<Letter> {
        val tmp = mutableListOf<Letter>()
        for (i in set) {
            tmp.add(Alphabet.letters[i])
        }
        return tmp
    }


    private fun generateSequence(endNumber: Int, size: Int): Set<Int> {
        return generateSequence {
            Random.nextInt(0..endNumber)
        }
            .distinct()
            .take(size)
            .sorted()
            .toSet()
    }
}

data class SingleQuestion(
    val rightAnswer: Letter? = null,
    val forms: List<Form> = mutableListOf()
) {
    fun isRightAnswer(index: Int): Boolean {
        if (rightAnswer == null) {
            return false
        }
        if (index < 0 || index >= forms.size) {
            return false
        }
        if (rightAnswer.hasForm(forms[index])) {
            return true
        }
        return false
    }
}
