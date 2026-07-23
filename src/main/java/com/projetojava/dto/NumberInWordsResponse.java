package com.projetotestejava.dto;

public class NumberInWordsResponse {
    private long numero;
    private String extenso;

    public NumberInWordsResponse(long numero, String extenso) {
        this.numero = numero;
        this.extenso = extenso;
    }

    public long getNumero() { return numero; }
    public String getExtenso() { return extenso; }
}
