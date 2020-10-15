package com.br.beertech.messages;

public class TransfMessage {

  private String contaDebito;
  private String contaCredito;
  private Double valor;

  public String getContaDebito() {
    return contaDebito;
  }

  public void setContaDebito(String contaDebito) {
    this.contaDebito = contaDebito;
  }

  public String getContaCredito() {
    return contaCredito;
  }

  public void setContaCredito(String contaCredito) {
    this.contaCredito = contaCredito;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  @Override
  public String toString() {
    return "TransfMessage{" +
        "contaDebito='" + contaDebito + '\'' +
        ", contaCredito='" + contaCredito + '\'' +
        ", valor=" + valor +
        '}';
  }
}
