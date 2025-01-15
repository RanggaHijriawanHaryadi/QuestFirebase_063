package com.example.firebasepam.ui.viewmodel

import android.net.http.HttpException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebasepam.model.Mahasiswa
import com.example.firebasepam.repository.MahasiswaRepository
import com.example.firebasepam.ui.navigate.DestinasiDetail
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch


class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val mahasiswaRepository: MahasiswaRepository
): ViewModel(){
    private val _nim: String = checkNotNull(savedStateHandle[DestinasiDetail.NIM])

    var detailUiState: DetailUiState by mutableStateOf(DetailUiState.Loading)
        private set

    init {
        getMahasiswaByNim()
    }

    fun getMahasiswaByNim(){
        viewModelScope.launch {
            detailUiState = DetailUiState.Loading
            mahasiswaRepository.getMahasiswaByNim(_nim)
                .onStart {
                    detailUiState = DetailUiState.Loading
                }
                .catch {
                    detailUiState = DetailUiState.Error(it)
                }
                .collect{
                      mahasiswa ->
                        detailUiState = DetailUiState.Success(mahasiswa)
                }
        }
    }
}

sealed class DetailUiState {
    data class Success(val mahasiswa: Mahasiswa) : DetailUiState()
    data class Error (val message : Throwable): DetailUiState()
    object Loading : DetailUiState()
}

