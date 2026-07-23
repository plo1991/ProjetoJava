package com.projetotestejava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Hello", description = "Endpoints de teste")
public class HelloController {

    @GetMapping("/hello")
    @Operation(summary = "Retorna uma saudação simples", description = "Exemplo de endpoint GET que retorna Hello, World!")
    public String hello() {
        return "Hello, World!";
    }
}
