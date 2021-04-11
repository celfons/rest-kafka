package br.com.celfons.commons

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandler: ResponseEntityExceptionHandler() {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @ExceptionHandler(value = [(Exception::class)])
    fun handler(exception: Exception): ResponseEntity<ErrorResponse> {
        logger.info(exception.message)
        val result = ErrorResponse(message = exception.message!!)
        return ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(value = [(BusinessException::class)])
    fun handler(exception: BusinessException): ResponseEntity<ErrorResponse> {
        logger.info(exception.message)
        val result = ErrorResponse(message = exception.message!!)
        return ResponseEntity(result, HttpStatus.NOT_FOUND)
    }

}

data class ErrorResponse(val message: String)
