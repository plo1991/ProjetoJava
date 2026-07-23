package com.projetotestejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.projetotestejava.dto.*;
import com.projetotestejava.service.*;

@RestController
@RequestMapping("/api/utilitarios")
@Tag(name = "Utilitários", description = "Ferramentas e utilitários diversos")
public class UtilityController {
    
    @Autowired private PersonGenerator personGenerator;
    @Autowired private NumberInWordsService numberInWordsService;
    @Autowired private EmailValidationService emailValidationService;
    @Autowired private HolidayService holidayService;
    @Autowired private CurrencyConverterService currencyConverterService;
    @Autowired private IpLocatorService ipLocatorService;
    
    @GetMapping("/barcode/{codigo}")
    @Operation(summary = "Gerar código de barras", description = "Gera um link para visualizar código de barras")
    public ResponseEntity<BarCodeResponse> gerarBarcode(
        @Parameter(description = "Código para gerar o código de barras", example = "123456789") @PathVariable String codigo
    ) {
        BarCodeResponse response = new BarCodeResponse(codigo, "code128");
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/qrcode")
    @Operation(summary = "Gerar QR Code", description = "Gera um QR Code para o texto fornecido (use query parameter 'texto')")
    public ResponseEntity<QrCodeResponse> gerarQrCode(
        @Parameter(description = "Texto ou URL para gerar o QR Code", example = "https://example.com") @RequestParam String texto
    ) {
        QrCodeResponse response = new QrCodeResponse(texto);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/qrcode/{texto}")
    @Operation(summary = "Gerar QR Code (alternativo)", description = "Gera um QR Code para texto simples (sem caracteres especiais)")
    public ResponseEntity<QrCodeResponse> gerarQrCodeSimples(
        @Parameter(description = "Texto simples para gerar o QR Code", example = "meutexto") @PathVariable String texto
    ) {
        QrCodeResponse response = new QrCodeResponse(texto);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/ip/{endereco}")
    @Operation(summary = "Localizar IP", description = "Retorna informações sobre um IP")
    public ResponseEntity<IpInfoResponse> localizarIp(
        @Parameter(description = "Endereço IP", example = "8.8.8.8") @PathVariable String endereco
    ) {
        IpInfoResponse response = ipLocatorService.localizarIp(endereco);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/moeda")
    @Operation(summary = "Converter moeda", description = "Converte valor entre moedas")
    public ResponseEntity<MoneyConversionResponse> converterMoeda(
        @Parameter(description = "Moeda origem (ex: USD)", example = "USD") @RequestParam String de,
        @Parameter(description = "Moeda destino (ex: BRL)", example = "BRL") @RequestParam String para,
        @Parameter(description = "Valor a converter", example = "100") @RequestParam double valor
    ) {
        MoneyConversionResponse response = currencyConverterService.converter(de, para, valor);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/pessoa")
    @Operation(summary = "Gerar pessoa aleatória", description = "Gera dados de uma pessoa fictícia para testes")
    public ResponseEntity<PersonResponse> gerarPessoa() {
        PersonResponse pessoa = personGenerator.gerarPessoa();
        return ResponseEntity.ok(pessoa);
    }
    
    @GetMapping("/feriados/{ano}")
    @Operation(summary = "Listar feriados", description = "Lista os feriados nacionais brasileiros para um ano")
    public ResponseEntity<?> listarFeriados(
        @Parameter(description = "Ano (ex: 2024)", example = "2024") @PathVariable int ano
    ) {
        return ResponseEntity.ok(holidayService.getFeriadosNacionais(ano));
    }
    
    @GetMapping("/numero-extenso/{numero}")
    @Operation(summary = "Número por extenso", description = "Converte um número em sua representação textual")
    public ResponseEntity<NumberInWordsResponse> numeroExtensoCf(
        @Parameter(description = "Número a converter", example = "12345") @PathVariable long numero
    ) {
        NumberInWordsResponse response = numberInWordsService.converter(numero);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/email/{email}")
    @Operation(summary = "Validar email", description = "Valida se um email tem formato correto")
    public ResponseEntity<EmailValidationResponse> validarEmail(
        @Parameter(description = "Email a validar", example = "usuario@email.com") @PathVariable String email
    ) {
        EmailValidationResponse response = emailValidationService.validar(email);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/fipe")
    @Operation(summary = "Tabela FIPE", description = "Exemplo de dados FIPE (integração com API real recomendada)")
    public ResponseEntity<FipeResponse> consultarFipe() {
        FipeResponse fipe = new FipeResponse("Toyota", "Corolla", 2023, "Gasolina", "R$ 95.000");
        return ResponseEntity.ok(fipe);
    }
}
