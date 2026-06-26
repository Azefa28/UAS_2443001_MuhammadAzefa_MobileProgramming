package com.example.bukutamudigital.data.repository

import com.example.bukutamudigital.data.dao.GuestDao
import com.example.bukutamudigital.data.entity.Guest
import kotlinx.coroutines.flow.Flow

class GuestRepository(private val guestDao: GuestDao) {

    suspend fun insertGuest(guest: Guest) {
        guestDao.insertGuest(guest)
    }

    fun getAllGuest(): Flow<List<Guest>> {
        return guestDao.getAllGuest()
    }

    suspend fun deleteGuest(guest: Guest) {
        guestDao.deleteGuest(guest)
    }

    suspend fun updateGuest(guest: Guest) {
        guestDao.updateGuest(guest)
    }
}