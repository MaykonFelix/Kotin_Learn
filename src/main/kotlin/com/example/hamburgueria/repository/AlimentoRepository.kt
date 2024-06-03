package com.example.hamburgueria.repository

import com.example.hamburgueria.controller.dto.AlimentoDto
import com.example.hamburgueria.domain.Alimento

interface AlimentoRepository {
    fun save(alimento: Alimento): Alimento
     fun findAll(): List<Alimento>
    fun findByNome(pesquisa: String): Alimento
    fun findById(id: Long): Alimento
    fun delete(id: Long)
    fun update(id: Long, alimentoDto: AlimentoDto): Alimento?
}