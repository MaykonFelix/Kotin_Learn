package com.example.hamburger.repository


import com.example.hamburger.controller.dto.AlimentoDto
import com.example.hamburger.domain.Alimento
import com.example.hamburger.exception.ElementoNaoEncontradoException
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
        try {
            return alimentoLista.first{it.nome == pesquisa}

        } catch (exception: NoSuchElementException){
            throw RuntimeException("Não foi possível pesquisar por nome: $pesquisa")
        }
    }

    override fun findById(id: Long): Alimento {
        try {
            return alimentoLista.first{it.id == id}

        } catch (exception: NoSuchElementException){
            throw ElementoNaoEncontradoException("Não foi possível pesquisar por id: $id")
        }
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