package com.example.hamburger.exception


import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpServerErrorException.InternalServerError

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    fun handlerInternalServerErrorException(ex: InternalServerError): ResponseEntity<MensagemException>{

        val mensagemException = MensagemException(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            ex.message
        )

        return ResponseEntity(mensagemException, HttpStatus.INTERNAL_SERVER_ERROR
        )
    }

    @ExceptionHandler
    fun handlerNoSuchElementExceptionException(ex: NoSuchElementException): ResponseEntity<MensagemException>{

        val mensagemException = MensagemException(
            HttpStatus.BAD_REQUEST.value(),
            ex.message
        )

        return ResponseEntity(mensagemException, HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler
    fun handlerRuntimeExceptionException(ex: RuntimeException): ResponseEntity<MensagemException>{

        val mensagemException = MensagemException(
            HttpStatus.BAD_REQUEST.value(),
            ex.message
        )

        return ResponseEntity(mensagemException, HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler
    fun handlerElementoNaoEncontradoException(ex: ElementoNaoEncontradoException): ResponseEntity<MensagemException>{

        val mensagemException = MensagemException(
            HttpStatus.NOT_FOUND.value(),
            ex.message
        )

        return ResponseEntity(mensagemException, HttpStatus.NOT_FOUND
        )
    }

    @ExceptionHandler
    fun handlerMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ResponseEntity<MensagemException>{

        val erros = ex.bindingResult.allErrors.map {
            val fieldNames = (it as FieldError).field
            val errorMessage = it.getDefaultMessage()
            val message = "$fieldNames - $errorMessage"
            message
        }
        val mensagemException = MensagemException(
            HttpStatus.BAD_REQUEST.value(),
            erros.toString()
        )

        return ResponseEntity(mensagemException, HttpStatus.BAD_REQUEST
        )
    }

}