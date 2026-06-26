package com.example.bukutamudigital.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bukutamudigital.data.entity.Guest
import com.example.bukutamudigital.data.repository.GuestRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class GuestViewModel(
    private val repository: GuestRepository
) : ViewModel() {

    val allGuest = repository.getAllGuest()

    fun insertGuest(guest: Guest) {
        viewModelScope.launch {
            repository.insertGuest(guest)
        }
    }

    fun deleteGuest(guest: Guest) {
        viewModelScope.launch {
            repository.deleteGuest(guest)
        }
    }
    fun updateGuest(guest: Guest) {
        viewModelScope.launch {
            repository.updateGuest(guest)
        }
    }
}