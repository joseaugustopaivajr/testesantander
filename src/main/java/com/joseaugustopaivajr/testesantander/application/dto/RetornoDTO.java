package com.joseaugustopaivajr.testesantander.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.joseaugustopaivajr.testesantander.application.utils.MessageResponseEnum;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class RetornoDTO {

    private Integer status;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataHora;

    private String message;

    private String optional;

    private String codigo;

    private Boolean creat_at;

    @Getter(lazy = true)
    private final List<CampoDTO> campos = new ArrayList<>();

    public RetornoDTO(MessageResponseEnum responseEnum) {
        this.status = responseEnum.getStatus();
        this.dataHora = LocalDateTime.now();
        this.message = responseEnum.getMensagem();
        this.codigo = responseEnum.getCodigo();
    }

    @Getter
    @Setter
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class CampoDTO{

        private String nome;

        private String message;

        public CampoDTO(String nome, String message){
            super();
            this.nome = nome;
            this.message = message;
        }
    }
}

