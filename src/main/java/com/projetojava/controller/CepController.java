package com.projetotestejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.projetotestejava.dto.CepResponse;
import com.projetotestejava.service.CepService;

@RestController
@RequestMapping("/api")
@Tag(name = "CEP", description = "Consulta de CEP")
public class CepController {
    
    @Autowired
    private CepService cepService;
    
    @GetMapping("/cep/{cep}")
    @Operation(
        summary = "Consultar endereço por CEP",
        description = "Retorna as informações de endereço correspondentes ao CEP fornecido. O CEP pode estar formatado (com hífen) ou não."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "CEP encontrado com sucesso",
            content = @Content(schema = @Schema(implementation = CepResponse.class))
        ),
        @ApiResponse(
            responseCode = "400",
            description = "CEP inválido ou não encontrado"
        )
    })
    public ResponseEntity<?> consultarCep(
        @Parameter(
            description = "CEP a ser consultado (formato: 12345-678 ou 12345678)",
            example = "01310-100"
        )
        @PathVariable String cep
    ) {
        CepResponse response = cepService.buscarCep(cep);
        
        if (response.isErro()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorResponse("CEP não encontrado ou inválido", cep)
            );
        }
        
        return ResponseEntity.ok(response);
    }
    
    public static class ErrorResponse {
        private String mensagem;
        private String cep;
        
        public ErrorResponse(String mensagem, String cep) {
            this.mensagem = mensagem;
            this.cep = cep;
        }
        
        public String getMensagem() { return mensagem; }
        public String getCep() { return cep; }
    }
}
