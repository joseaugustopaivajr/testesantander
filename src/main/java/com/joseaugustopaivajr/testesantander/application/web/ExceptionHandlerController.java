package com.joseaugustopaivajr.testesantander.application.web;

import com.joseaugustopaivajr.testesantander.application.dto.RetornoDTO;
import com.joseaugustopaivajr.testesantander.domain.exception.CepNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.UnknownContentTypeException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static com.joseaugustopaivajr.testesantander.application.utils.MessageResponseEnum.*;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ExceptionHandlerController {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public RetornoDTO handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.info("[MethodArgumentTypeMismatchException]");
        return new RetornoDTO(METODO_INVALIDO);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(CepNotFoundException.class)
    public RetornoDTO handlerCepNotFound(CepNotFoundException ex){
        log.info("[CepNotFoundException]");
        return new RetornoDTO(CEP_NOTFOUND);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UnknownContentTypeException.class)
    public RetornoDTO handlerParseConversionError(UnknownContentTypeException ex){
        log.info("[UnknownContentTypeException]");
        return new RetornoDTO(ERRO_REQUEST);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public RetornoDTO handleRuntimeException(RuntimeException ex) {
        log.info("[RuntimeException]");
        return new RetornoDTO(ERRO_INTERNO);
    }
}
