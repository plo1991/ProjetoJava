package com.projetotestejava.dto;

public class BarCodeResponse {
    private String codigo;
    private String formato;
    private String imageUrl;

    public BarCodeResponse(String codigo, String formato) {
        this.codigo = codigo;
        this.formato = formato;
        this.imageUrl = "https://barcodes.aspose.app/barcode/generate?text=" + codigo + "&format=" + formato;
    }

    public String getCodigo() { return codigo; }
    public String getFormato() { return formato; }
    public String getImageUrl() { return imageUrl; }
}
