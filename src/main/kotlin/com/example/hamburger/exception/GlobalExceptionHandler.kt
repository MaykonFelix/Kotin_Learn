package com.example.hamburger.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpServerErrorException.InternalServerError

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    fun handlerInternalServerErrorExcepetion(ex: InternalServerError): ResponseEntity<MensagemException>{

        val mensagemException = MensagemException(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            ex.message
        )

        return ResponseEntity(mensagemException, HttpStatus.INTERNAL_SERVER_ERROR
        )
    }

    @ExceptionHandler
    fun handlerNoSuchElementExceptionExcepetion(ex: NoSuchElementException): ResponseEntity<MensagemException>{

        val mensagemException = MensagemException(
            HttpStatus.BAD_REQUEST.value(),
            ex.message
        )

        return ResponseEntity(mensagemException, HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler
    fun handlerRuntimeExceptionExcepetion(ex: RuntimeException): ResponseEntity<MensagemException>{

        val mensagemException = MensagemException(
            HttpStatus.BAD_REQUEST.value(),
            ex.message
        )

        return ResponseEntity(mensagemException, HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler
    fun handlerElementoNaoEncontradoExcepetion(ex: ElementoNaoEncontradoException): ResponseEntity<MensagemException>{

        val mensagemException = MensagemException(
            HttpStatus.NOT_FOUND.value(),
            ex.message
        )

        return ResponseEntity(mensagemException, HttpStatus.NOT_FOUND
        )
    }

}