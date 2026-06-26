package com.example.bukutamudigital.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "purpose")
data class Purpose(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val nama_keperluan: String
)