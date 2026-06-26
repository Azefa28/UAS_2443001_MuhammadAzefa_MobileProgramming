package com.example.bukutamudigital.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "visit",
    foreignKeys = [

        ForeignKey(
            entity = Guest::class,
            parentColumns = ["id"],
            childColumns = ["guestId"],
            onDelete = ForeignKey.CASCADE
        ),

        ForeignKey(
            entity = Purpose::class,
            parentColumns = ["id"],
            childColumns = ["purposeId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("guestId"),
        Index("purposeId")
    ]
)
data class Visit(

    @PrimaryKey(autoGenerate = true)
    val visitId: Int = 0,

    val guestId: Int,

    val purposeId: Int,

    val tanggal: String,

    val jam: String
)