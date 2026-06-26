package com.example.bukutamudigital.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bukutamudigital.repository.PurposeRepository

class PurposeViewModelFactory(
    private val repository: PurposeRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(PurposeViewModel::class.java)) {

            @Suppress("UNCHECKED_CAST")
            return PurposeViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}