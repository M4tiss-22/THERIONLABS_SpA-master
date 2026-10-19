package com.example.therionlabs_spa.data.repository

import com.example.therionlabs_spa.data.local.LeadDao
import com.example.therionlabs_spa.data.local.LeadEntity
import kotlinx.coroutines.flow.Flow

class LeadRepository(private val dao: LeadDao) {
    val todosLosProspectos: Flow<List<LeadEntity>> = dao.obtenerTodoLosProspectos()
    val cantidadPendiente: Flow<Int> = dao.obtenerCantidadPendientes()

    suspend fun guardarProspectos(prospectos : LeadEntity): Boolean {
        return dao.insertarProspecto(prospectos) > 0
    }
}