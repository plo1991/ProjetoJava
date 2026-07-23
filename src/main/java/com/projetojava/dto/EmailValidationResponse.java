package com.projetotestejava.dto;

public class EmailValidationResponse {
    private String email;
    private boolean valido;
    private String mensagem;

    public EmailValidationResponse(String email, boolean valido, String mensagem) {
        this.email = email;
        this.valido = valido;
        this.mensagem = mensagem;
    }

    public String getEmail() { return email; }
    public boolean isValido() { return valido; }
    public String getMensagem() { return mensagem; }
}
