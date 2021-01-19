package com.express.cadastro.controller.handler;

import com.express.cadastro.exception.NotFound;
import com.express.cadastro.response.NotFoundResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotFound.class)
    public NotFoundResponse handle(NotFound e) {
        NotFoundResponse notFoundResponse = new NotFoundResponse();
        notFoundResponse.setDateTime(LocalDateTime.now());
        notFoundResponse.setMessage("Not found object");

        return notFoundResponse;
    }
}
