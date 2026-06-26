package com.example.bukutamudigital.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bukutamudigital.data.dao.GuestDao
import com.example.bukutamudigital.data.dao.PurposeDao
import com.example.bukutamudigital.data.dao.VisitDao
import com.example.bukutamudigital.data.entity.Guest
import com.example.bukutamudigital.data.entity.Purpose
import com.example.bukutamudigital.data.entity.Visit

@Database(
    entities = [
        Guest::class,
        Purpose::class,
        Visit::class
    ],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun guestDao(): GuestDao

    abstract fun purposeDao(): PurposeDao

    abstract fun visitDao(): VisitDao
}