package com.example.hamburger.service

import com.example.hamburger.controller.dto.AlimentoDto
import com.example.hamburger.domain.Alimento
import com.example.hamburger.repository.AlimentoRepository
import org.springframework.stereotype.Service

@Service
class AlimentoService(
    private val alimentoRepository: AlimentoRepository
) {
    fun save(alimentoDto: AlimentoDto):Alimento{
        return alimentoRepository.save(alimentoDto.paraDomain())
    }

    fun buscarTodos():List<Alimento> {
        return alimentoRepository.findAll()
    }

    fun buscarComFiltro(pesquisa: String): Alimento {
    val id = pesquisa.toLongOrNull()
        if(id == null){
            return alimentoRepository.findByNome(pesquisa)
        } else {
            return alimentoRepository.findById(id)
        }
    }

    fun deletar(id: Long) {
        alimentoRepository.delete(id)
    }

    fun atualizar(id: Long, alimentoDto: AlimentoDto): Alimento? {
        return alimentoRepository.update(id, alimentoDto)
    }
}