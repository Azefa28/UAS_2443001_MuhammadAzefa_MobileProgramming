package com.example.bukutamudigital.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guest")
data class Guest(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama: String,
    val instansi: String,
    val email: String,
    val noHp: String
)