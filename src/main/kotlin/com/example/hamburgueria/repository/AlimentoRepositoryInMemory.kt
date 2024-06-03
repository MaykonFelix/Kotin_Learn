package com.example.hamburgueria.repository

import com.example.hamburgueria.controller.dto.AlimentoDto
import com.example.hamburgueria.domain.Alimento
import org.springframework.stereotype.Component

@Component
class AlimentoRepositoryInMemory():AlimentoRepository {
    private val alimentoLista: MutableList<Alimento>
    private var indice: Long = 0

    init{
        alimentoLista = ArrayList()
    }

    override fun save(alimento: Alimento): Alimento {
        indice++
        alimento.id = indice
        alimentoLista.add(alimento)
        return alimento
    }

    override fun findAll(): List<Alimento> {
      return alimentoLista
    }

    override fun findByNome(pesquisa: String): Alimento {
    return alimentoLista.first{it.nome == pesquisa}
    }

    override fun findById(id: Long): Alimento {
        return alimentoLista.first{it.id == id}
    }

    override fun delete(id: Long) {
        alimentoLista.removeIf{it.id == id}
    }

    override fun update(id: Long, alimentoDto: AlimentoDto): Alimento? {

        var alimentoNew: Alimento? = null
        alimentoLista.forEachIndexed { index, alimento ->
            if(alimento.id == id){
                alimentoLista[index] = alimento.copy(
                    nome = alimentoDto.nome,
                    descricao = alimentoDto.descricao,
                    preco = alimentoDto.preco,
                    categoria = alimentoDto.categoria
                )
                alimentoNew = alimentoLista[index]
            }
        }
        return alimentoNew
    }
}