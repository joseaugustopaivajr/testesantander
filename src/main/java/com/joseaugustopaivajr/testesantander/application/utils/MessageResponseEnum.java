package com.joseaugustopaivajr.testesantander.application.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MessageResponseEnum {

    METODO_INVALIDO(HttpStatus.BAD_REQUEST.value(), "Método inválido", "METHOD.INVALID"),
    CEP_NOTFOUND(HttpStatus.BAD_GATEWAY.value(), "CEP não encontrado", "CEP.NOTFOUND"),
    ERRO_REQUEST(HttpStatus.BAD_REQUEST.value(), "Houve um erro ao processar os dados", "ERRO.REQUEST"),
    ERRO_INTERNO(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro na requisição", "ERROR.APPLICATION");

    private final Integer status;
    private final String mensagem;
    private final String codigo;

}
