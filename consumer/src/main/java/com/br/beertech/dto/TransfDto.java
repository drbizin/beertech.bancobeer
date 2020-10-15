package com.br.beertech.dto;

public class TransfDto {

    private String contaCredito;
    private String contaDebito;
    private Double valor;

    public TransfDto(String contaDebito, String contaCredito, Double valor) {
        this.contaCredito = contaCredito;
        this.contaDebito = contaDebito;
        this.valor = valor;
    }

    public String getContaCredito() {
        return contaCredito;
    }

    public void setContaCredito(String contaCredito) {
        contaCredito = contaCredito;
    }

    public String getContaDebito() {
        return contaDebito;
    }

    public void setContaDebito(String contaDebito) {
        contaDebito = contaCredito;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
