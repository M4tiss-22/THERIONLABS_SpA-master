package com.example.therionlabs_spa.data.local

import androidx.room.*
import kotlinx.coroutines.flow.*


@Dao
interface LeadDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarProspecto(prospecto: LeadEntity): Long

    @Query("SELECT * FROM prospectos ORDER BY fechaCaptura DESC")
    fun obtenerTodoLosProspectos(): Flow<List<LeadEntity>>

@Query("SELECT COUNT(*) FROM prospectos WHERE estaSincronizado = 0")
    fun obtenerCantidadPendientes(): Flow<Int>
}