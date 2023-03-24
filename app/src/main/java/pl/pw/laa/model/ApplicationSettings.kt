package pl.pw.laa.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ApplicationSettings (
    @PrimaryKey
    val id: Long = 1,
    var possibleAnswers: Int = 8,
    var areCheatsOn: Boolean = true,
    var areTipsInTestOn: Boolean = true,
    var areTipsInAlphabetOn: Boolean = true,
    var areAdsOn: Boolean = true,
)
