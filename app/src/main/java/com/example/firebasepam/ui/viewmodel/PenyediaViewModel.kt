package com.example.firebasepam.ui.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.firebasepam.MahasiswaApplications

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiMhs().container.mahasiswaRepository)
        }
        initializer {
            InsertViewModel(aplikasiMhs().container.mahasiswaRepository)
        }
        initializer {
            DetailViewModel(createSavedStateHandle(),aplikasiMhs().container.mahasiswaRepository)
        }
    }
}
fun CreationExtras.aplikasiMhs(): MahasiswaApplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)

