package com.example.bukutamudigital.data.dao

import androidx.room.*
import com.example.bukutamudigital.data.entity.Purpose
import kotlinx.coroutines.flow.Flow
import androidx.room.Delete

@Dao
interface PurposeDao {

    @Insert
    suspend fun insertPurpose(purpose: Purpose)

    @Update
    suspend fun updatePurpose(purpose: Purpose)

    @Delete
    suspend fun deletePurpose(purpose: Purpose)

    @Query("SELECT * FROM purpose")
    fun getAllPurpose(): Flow<List<Purpose>>
}