package com.example.hamburger.domain

import java.math.BigDecimal

data class Alimento(
    var id: Long?,
    val nome: String,
    val descricao: String,
    val preco: BigDecimal,
    val categoria: String
)


