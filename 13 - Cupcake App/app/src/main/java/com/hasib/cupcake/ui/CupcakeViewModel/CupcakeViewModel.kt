package com.hasib.cupcake.ui.CupcakeViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CupcakeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(CupcakeUiState())
    val uiState: StateFlow<CupcakeUiState>
        get() = _uiState.asStateFlow()

    fun updateUi(
        subtotal: Int = uiState.value.subtotal,
        quantity: String = uiState.value.quantity,
        flavor: String = uiState.value.flavor,
        pickupDate: String = ""
    ) {

        _uiState.update { currentSate ->
            currentSate.copy(
                subtotal = subtotal,
                quantity = quantity,
                flavor = flavor,
                pickupDate = pickupDate
            )
        }
    }

    fun resetUi() {
        _uiState.update { currentState ->
            currentState.copy(
                subtotal = 0,
                quantity = "",
                flavor = "",
                pickupDate = ""
            )
        }
    }
}