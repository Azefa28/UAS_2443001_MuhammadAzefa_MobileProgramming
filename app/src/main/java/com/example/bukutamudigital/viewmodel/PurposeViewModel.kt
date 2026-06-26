package com.example.bukutamudigital.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bukutamudigital.data.entity.Purpose
import com.example.bukutamudigital.repository.PurposeRepository
import kotlinx.coroutines.launch

class PurposeViewModel(
    private val repository: PurposeRepository
) : ViewModel() {

    val allPurpose = repository.allPurpose

    fun insertPurpose(purpose: Purpose) {
        viewModelScope.launch {
            repository.insertPurpose(purpose)
        }
    }
    fun deletePurpose(purpose: Purpose) {
        viewModelScope.launch {
            repository.deletePurpose(purpose)
        }
    }
    fun updatePurpose(purpose: Purpose) {
        viewModelScope.launch {
            repository.updatePurpose(purpose)
        }
    }
}