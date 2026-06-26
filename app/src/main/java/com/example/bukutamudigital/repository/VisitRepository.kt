package com.example.bukutamudigital.data.repository

import com.example.bukutamudigital.data.dao.VisitDao
import com.example.bukutamudigital.data.entity.Visit
import kotlinx.coroutines.flow.Flow

class VisitRepository(private val visitDao: VisitDao) {

    suspend fun insertVisit(visit: Visit) {
        visitDao.insertVisit(visit)
    }

    suspend fun updateVisit(visit: Visit) {
        visitDao.updateVisit(visit)
    }

    suspend fun deleteVisit(visit: Visit) {
        visitDao.deleteVisit(visit)
    }

    fun getVisitReport() = visitDao.getVisitReport()
}