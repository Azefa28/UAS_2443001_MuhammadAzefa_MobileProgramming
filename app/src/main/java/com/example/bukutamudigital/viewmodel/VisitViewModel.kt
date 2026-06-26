package com.example.bukutamudigital.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bukutamudigital.data.entity.Visit
import com.example.bukutamudigital.data.repository.VisitRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class VisitViewModel(
    private val repository: VisitRepository
) : ViewModel() {

    val visitReport = repository.getVisitReport()

    fun insertVisit(visit: Visit) {
        viewModelScope.launch {
            repository.insertVisit(visit)
        }
    }
    fun updateVisit(visit: Visit) {
        viewModelScope.launch {
            repository.updateVisit(visit)
        }
    }
}