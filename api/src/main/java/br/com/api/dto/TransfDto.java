package br.com.api.dto;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class TransfDto {

    private String contaDebito;
    private String contaCredito;
    private Double valor;

}
