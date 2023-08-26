package com.hasib.unscamble.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hasib.unscamble.Data.Words
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState>
        get() = _uiState.asStateFlow()

    private lateinit var currentWord: String
    private var usedWords: MutableSet<String> = mutableSetOf()

    var userGuess by mutableStateOf("")
        private set

    fun guessedWord(word: String) {
        userGuess = word
    }

    fun pickRandomWordAndShuffle(): String {
        currentWord = Words().words.random()
        if(usedWords.contains(currentWord)) {
            return pickRandomWordAndShuffle()
        }else {
            usedWords.add(currentWord)
            return shuffleCurrentWord(currentWord)
        }
    }

    fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        tempWord.shuffle()
        while (String(tempWord).equals(word)) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }

    //Checking user guess
    fun checkUserGuess() {
        if(userGuess.equals(currentWord, ignoreCase = true)) {
            val updatedScore = _uiState.value.score.plus(1)
            updateGameState(updatedScore)
        }else {
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
        guessedWord("")
    }

    //Update game state
    private fun updateGameState(updatedScore: Int) {
        if(usedWords.size == 10) {
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
             }
        }else {
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    currentScrambleWord = pickRandomWordAndShuffle(),
                    score = updatedScore,
                    currentWordCount = currentState.currentWordCount.inc()
                )
            }
        }
    }


    //skip word
    fun skipWord(){
        updateGameState(_uiState.value.score)
        guessedWord("")
    }






    fun resetGame() {
        usedWords.clear()
        currentWord = pickRandomWordAndShuffle()
        _uiState.value = GameUiState(currentWord)
    }

    init {
        resetGame()
    }
}