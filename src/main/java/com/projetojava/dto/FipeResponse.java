package com.projetotestejava.dto;

public class FipeResponse {
    private String marca;
    private String modelo;
    private int ano;
    private String combustivel;
    private String valor;

    public FipeResponse(String marca, String modelo, int ano, String combustivel, String valor) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.combustivel = combustivel;
        this.valor = valor;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAno() { return ano; }
    public String getCombustivel() { return combustivel; }
    public String getValor() { return valor; }
}
