package br.com.luquinhas.loja.exception

import br.com.luquinhas.loja.dto.ErrorView
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(
        exception: NotFoundException,
        request: HttpServletRequest,
    ): ErrorView {
        return ErrorView(error = HttpStatus.NOT_FOUND.name,
            status = HttpStatus.NOT_FOUND.value(),
            mensagem = exception.message,
            path = request.servletPath)
    }
}