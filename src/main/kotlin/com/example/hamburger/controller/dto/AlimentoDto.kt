package com.example.hamburger.controller.dto

import com.example.hamburger.domain.Alimento
import java.math.BigDecimal

class AlimentoDto(
    val nome: String,
    val descricao: String,
    val preco: BigDecimal,
    val categoria: String
){
    fun paraDomain(): Alimento{
        return Alimento(
            id = null,
            nome = nome,
            descricao = descricao,
            preco = preco,
            categoria = categoria
        )

    }

}