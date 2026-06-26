package com.example.bukutamudigital.data.dao

import androidx.room.*
import com.example.bukutamudigital.data.entity.Visit
import kotlinx.coroutines.flow.Flow
import com.example.bukutamudigital.data.model.VisitReport


@Dao
interface VisitDao {

    @Insert
    suspend fun insertVisit(visit: Visit)

    @Update
    suspend fun updateVisit(visit: Visit)

    @Delete
    suspend fun deleteVisit(visit: Visit)

    @Query("""
SELECT visit.visitId, guest.nama, purpose.nama_keperluan, visit.tanggal, visit.jam
FROM visit
INNER JOIN guest ON guest.id = visit.guestId
INNER JOIN purpose ON purpose.id = visit.purposeId
""")
    fun getVisitReport(): Flow<List<VisitReport>>
}