package com.br.beertech.listeners;

import com.br.beertech.dto.TransacaoDto;
import com.br.beertech.dto.TransfDto;
import com.br.beertech.messages.OperacaoMessage;
import com.br.beertech.messages.TransfMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TransfListener {

  private final RestTemplate restTemplate;

  @Autowired
  public TransfListener(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @RabbitListener(queues = "transferencia",containerFactory = "simpleContainerFactory")
  public void receive(@Payload TransfMessage transfMessage){
    System.out.println("Transferencia da conta:" + transfMessage.getContaDebito() +
                       " para a conta:" + transfMessage.getContaCredito());
    TransfDto transfDto = new TransfDto(transfMessage.getContaDebito(),transfMessage.getContaCredito(), transfMessage.getValor());
    try{
      restTemplate.postForObject("http://localhost:8080/transferencias/" , transfDto ,Void.class);
    }catch (Exception e){
      System.out.println("Error on try request");
    }
  }
}
