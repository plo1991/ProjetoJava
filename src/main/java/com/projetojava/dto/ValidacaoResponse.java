package com.projetotestejava.dto;

public class ValidacaoResponse {
    private String numero;
    private boolean valido;
    private String tipo;
    private String mensagem;

    public ValidacaoResponse() {}

    public ValidacaoResponse(String numero, boolean valido, String tipo, String mensagem) {
        this.numero = numero;
        this.valido = valido;
        this.tipo = tipo;
        this.mensagem = mensagem;
    }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public boolean isValido() { return valido; }
    public void setValido(boolean valido) { this.valido = valido; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
}
