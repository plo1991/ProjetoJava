package com.projetotestejava.dto;

public class MoneyConversionResponse {
    private String de;
    private String para;
    private double valor;
    private double resultado;
    private double taxa;

    public MoneyConversionResponse(String de, String para, double valor, double taxa) {
        this.de = de;
        this.para = para;
        this.valor = valor;
        this.taxa = taxa;
        this.resultado = valor * taxa;
    }

    public String getDe() { return de; }
    public String getPara() { return para; }
    public double getValor() { return valor; }
    public double getResultado() { return resultado; }
    public double getTaxa() { return taxa; }
}
