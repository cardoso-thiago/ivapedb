package br.com.serval.exception

import br.com.serval.model.ErrorMessage
import br.com.serval.util.IVapeDbConstants
import org.postgresql.util.PSQLException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(PSQLException::class)
    fun handlePostgreException(ex: PSQLException): ResponseEntity<ErrorMessage> {
        if (ex.localizedMessage.contains(IVapeDbConstants.ERROR_DUPLICATE_KEY)) {
            val status = HttpStatus.CONFLICT
            val errorMessage = createErrorMessage(status, listOf(ex.localizedMessage.split("Detalhe: ")[1]))
            return ResponseEntity.status(status).body(errorMessage)
        }
        val status = HttpStatus.INTERNAL_SERVER_ERROR
        val errorMessage = createErrorMessage(status, listOf(ex.localizedMessage))
        return ResponseEntity.status(status).body(errorMessage)
    }

    private fun createErrorMessage(status: HttpStatus, message: List<String>) =
        ErrorMessage(status.value(), status.reasonPhrase, message)
}