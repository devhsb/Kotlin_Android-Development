package com.hasib.dessertclicker.ui.DessertViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.hasib.dessertclicker.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel : ViewModel() {
    private val _uiState =  MutableStateFlow(DessertUiState())
    val uiState: StateFlow<DessertUiState>
        get() = _uiState.asStateFlow()

    //solded desserts
    fun addDessert() {
        val updatedValue = uiState.value.solded.inc()
        val updatedRevenue: Int
        val updatedImageId: Int

        if(updatedValue > 4) {
            updatedRevenue = uiState.value.revenue.plus(10)
            updatedImageId = R.drawable.donut
            _uiState.update { currentState ->
                currentState.copy(
                    imageId = updatedImageId,
                    solded = updatedValue,
                    revenue = updatedRevenue
                )
            }
        }else {
            updatedRevenue = uiState.value.revenue.plus(5)
            _uiState.update { currentState ->
                currentState.copy(
                    solded = updatedValue,
                    revenue = updatedRevenue
                )
            }
        }
    }
}