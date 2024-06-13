package com.example.hamburger.repository

import com.example.hamburger.controller.dto.AlimentoDto
import com.example.hamburger.domain.Alimento

interface AlimentoRepository {
    fun save(alimento: Alimento): Alimento
    fun findAll(): List<Alimento>
    fun findByNome(pesquisa: String): Alimento
    fun findById(id: Long): Alimento
    fun delete(id: Long)
    fun update(id: Long, alimentoDto: AlimentoDto): Alimento?
}