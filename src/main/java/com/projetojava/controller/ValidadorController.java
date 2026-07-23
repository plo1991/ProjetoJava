package com.projetotestejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.projetotestejava.dto.ValidacaoResponse;
import com.projetotestejava.service.CpfCnpjValidator;

@RestController
@RequestMapping("/api/validador")
@Tag(name = "Validador", description = "Validação de CPF e CNPJ")
public class ValidadorController {
    
    @Autowired
    private CpfCnpjValidator validator;
    
    @GetMapping("/cpf/{cpf}")
    @Operation(
        summary = "Validar CPF",
        description = "Valida um CPF verificando os dígitos verificadores. O CPF pode estar formatado (XXX.XXX.XXX-XX) ou não."
    )
    @ApiResponse(
        responseCode = "200",
        description = "Validação realizada com sucesso",
        content = @Content(schema = @Schema(implementation = ValidacaoResponse.class))
    )
    public ResponseEntity<ValidacaoResponse> validarCPF(
        @Parameter(
            description = "CPF a ser validado (formato: 123.456.789-09 ou 12345678909)",
            example = "123.456.789-09"
        )
        @PathVariable String cpf
    ) {
        boolean valido = validator.validarCPF(cpf);
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");
        
        ValidacaoResponse response = new ValidacaoResponse(
            cpfLimpo,
            valido,
            "CPF",
            valido ? "CPF válido" : "CPF inválido"
        );
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/cnpj/{cnpj}")
    @Operation(
        summary = "Validar CNPJ",
        description = "Valida um CNPJ verificando os dígitos verificadores. O CNPJ pode estar formatado (XX.XXX.XXXOXXXXXX - sem barra) ou sem formatação (14 dígitos)."
    )
    @ApiResponse(
        responseCode = "200",
        description = "Validação realizada com sucesso",
        content = @Content(schema = @Schema(implementation = ValidacaoResponse.class))
    )
    public ResponseEntity<ValidacaoResponse> validarCNPJ(
        @Parameter(
            description = "CNPJ a ser validado (formato: 34028316000106 ou 34.028.316.0001.06 - sem a barra)",
            example = "34028316000106"
        )
        @PathVariable String cnpj
    ) {
        boolean valido = validator.validarCNPJ(cnpj);
        String cnpjLimpo = cnpj.replaceAll("[^0-9]", "");
        
        ValidacaoResponse response = new ValidacaoResponse(
            cnpjLimpo,
            valido,
            "CNPJ",
            valido ? "CNPJ válido" : "CNPJ inválido"
        );
        
        return ResponseEntity.ok(response);
    }
}
