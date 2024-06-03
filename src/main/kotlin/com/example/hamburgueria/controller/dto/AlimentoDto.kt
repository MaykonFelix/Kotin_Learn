package com.example.hamburgueria.controller.dto

import com.example.hamburgueria.domain.Alimento
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