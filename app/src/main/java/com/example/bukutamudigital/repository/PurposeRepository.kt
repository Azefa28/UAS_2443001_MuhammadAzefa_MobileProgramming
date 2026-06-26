package com.example.bukutamudigital.repository

import com.example.bukutamudigital.data.dao.PurposeDao
import com.example.bukutamudigital.data.entity.Purpose

class PurposeRepository(private val purposeDao: PurposeDao) {

    val allPurpose = purposeDao.getAllPurpose()

    suspend fun insertPurpose(purpose: Purpose) {
        purposeDao.insertPurpose(purpose)
    }
    suspend fun deletePurpose(purpose: Purpose) {
        purposeDao.deletePurpose(purpose)
    }

    suspend fun updatePurpose(purpose: Purpose) {
        purposeDao.updatePurpose(purpose)
    }
}