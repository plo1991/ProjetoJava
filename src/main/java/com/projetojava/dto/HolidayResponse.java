package com.projetotestejava.dto;

public class HolidayResponse {
    private String data;
    private String nome;
    private String tipo;

    public HolidayResponse(String data, String nome, String tipo) {
        this.data = data;
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getData() { return data; }
    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
}
