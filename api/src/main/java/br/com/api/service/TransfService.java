package br.com.api.service;

import br.com.api.dto.TransfDto;
import br.com.api.model.Conta;
import br.com.api.model.Transf;
import br.com.api.repository.TransfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransfService {

    private ContaService contaService;

    private TransfRepository transfRepository;

    @Autowired
    public TransfService(ContaService contaService, TransfRepository transfRepository) {
        this.contaService = contaService;
        this.transfRepository = transfRepository;
    }


    public Transf criarTrasnf(TransfDto transfDto){
        Conta contaOrigem = contaService.findByHash(transfDto.getContaDebito());
        if (contaOrigem.getSaldo() < transfDto.getValor()){
            throw new RuntimeException("Saldo insuficiente");
        }
        Conta contaDestino = contaService.findByHash(transfDto.getContaCredito());
        contaDestino.deposito(contaOrigem.saque(transfDto.getValor()));

        Transf transf = new Transf();
        transf.setContaOrigemHash(transfDto.getContaDebito());
        transf.setContaDestinoHash(transfDto.getContaCredito());
        transf.setValor(transfDto.getValor());
        Transf save = transfRepository.save(transf);

        contaService.atualizarConta(contaOrigem);
        contaService.atualizarConta(contaDestino);
        return save;
    }
}
