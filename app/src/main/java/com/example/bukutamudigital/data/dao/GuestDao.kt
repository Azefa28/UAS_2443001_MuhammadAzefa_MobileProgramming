package com.example.bukutamudigital.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.bukutamudigital.data.entity.Guest
import kotlinx.coroutines.flow.Flow
import androidx.room.Delete
import androidx.room.Update

@Dao
interface GuestDao {

    @Insert
    suspend fun insertGuest(guest: Guest)

    @Query("SELECT * FROM guest")
    fun getAllGuest(): Flow<List<Guest>>

    @Delete
    suspend fun deleteGuest(guest: Guest)

    @Update
    suspend fun updateGuest(guest: Guest)
}