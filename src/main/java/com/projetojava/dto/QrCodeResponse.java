package com.projetotestejava.dto;

public class QrCodeResponse {
    private String texto;
    private String imageUrl;

    public QrCodeResponse(String texto) {
        this.texto = texto;
        this.imageUrl = "https://api.qrserver.com/v1/create-qr-code/?size=300x300&data=" + texto;
    }

    public String getTexto() { return texto; }
    public String getImageUrl() { return imageUrl; }
}
