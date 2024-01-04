package com.hasib.amphibians.ui.theme.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.hasib.amphibians.AmphibiansApplication
import com.hasib.amphibians.data.AmphibianModel
import com.hasib.amphibians.data.AmphibianRepository
import kotlinx.coroutines.launch
import java.io.IOException


class AmphibianViewModel(
    val amphibiansRepository: AmphibianRepository
) : ViewModel() {
    var amphibianUiState = mutableStateOf<List<AmphibianModel>>(emptyList())

    init {
        getAmphibian()
    }

    fun getAmphibian(){
            viewModelScope.launch {
                try{
                    amphibianUiState.value =  amphibiansRepository.getAmphibians()
                }catch (e: IOException){
                    amphibianUiState.value = emptyList()
                }
            }
    }

    companion object {
        val Factory : ViewModelProvider.Factory  = viewModelFactory{
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
                val amphibiansApplication = application.container.amphibianRepository
                AmphibianViewModel(amphibiansApplication)
            }
        }
    }
}

