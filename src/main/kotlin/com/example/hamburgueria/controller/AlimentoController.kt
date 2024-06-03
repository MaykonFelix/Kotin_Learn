package com.example.hamburgueria.controller

import com.example.hamburgueria.controller.dto.AlimentoDto
import com.example.hamburgueria.domain.Alimento
import com.example.hamburgueria.service.AlimentoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/alimento")
class AlimentoController(
    private val alimentoService: AlimentoService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun salvar(@RequestBody alimentoDto: AlimentoDto): Alimento {
        return alimentoService.save(alimentoDto)
    }
    @GetMapping
    fun buscarTodos(): List<Alimento>{
        return alimentoService.buscarTodos()
    }
    @GetMapping("/{pesquisa}")
    fun buscarComFiltro(@PathVariable pesquisa: String): Alimento{
        return alimentoService.buscarComFiltro(pesquisa)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long){
        return alimentoService.deletar(id)
    }
    @PutMapping("/{id}")
    fun deletar(@PathVariable id: Long, @RequestBody alimentoDto: AlimentoDto): Alimento?{
        return alimentoService.atualizar(id, alimentoDto)
    }


}