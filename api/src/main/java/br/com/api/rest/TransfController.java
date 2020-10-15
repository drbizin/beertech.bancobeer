package br.com.api.rest;

import br.com.api.dto.TransacaoDto;
import br.com.api.dto.TransfDto;
import br.com.api.model.Conta;
import br.com.api.model.Transf;
import br.com.api.service.ContaService;
import br.com.api.service.TransfService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TransfController {

    @Autowired
    TransfService transfService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "Realizar transferencia.", produces = "application/json")

    public Transf criarTransf(
            @Valid @RequestBody TransfDto request
    ) {

        return transfService.criarTrasnf(request);
    }
}