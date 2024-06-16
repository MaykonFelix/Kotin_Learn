package com.example.hamburger.controller.dto

import com.example.hamburger.domain.Alimento
import jakarta.validation.constraints.*
import java.math.BigDecimal

class AlimentoDto(
    @field:NotBlank( message = "o nome é obrigatório")
    @field:Size(min = 3, max = 20, message = "o nome deve ter mais que 3 ou menos que 20 caracteres")
    val nome: String? = null,
    @field:NotBlank( message = "a descrição é obrigatório")
    val descricao: String? = null,
    @field:NotNull( message = "o preço é obrigatório")
    @field:Min(value = 0, message = "o preço dever ser maior do que zero")
    val preco: BigDecimal? = null,
    @field:NotBlank( message = "o nome é obrigatório")
    @field:Size(max = 20, message = "a categoria deve ter menos que 20 caracteres" )
    val categoria: String? = null
) {
    fun paraDomain(): Alimento {
        return Alimento(
            id = null,
            nome = nome!!,
            descricao = descricao!!,
            preco = preco!!,
            categoria = categoria!!
        )
    }
}