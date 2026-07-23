package com.projetotestejava.service;

import org.springframework.stereotype.Service;
import com.projetotestejava.dto.NumberInWordsResponse;

@Service
public class NumberInWordsService {
    private static final String[] UNIDADES = {"", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};
    private static final String[] DEZENAS = {"", "dez", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};
    private static final String[] ESPECIAIS = {"dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};
    
    public NumberInWordsResponse converter(long numero) {
        String extenso = converterParaExtenso(numero);
        return new NumberInWordsResponse(numero, extenso);
    }
    
    private String converterParaExtenso(long numero) {
        if (numero == 0) return "zero";
        if (numero < 0) return "menos " + converterParaExtenso(-numero);
        if (numero < 10) return UNIDADES[(int)numero];
        if (numero < 20) return ESPECIAIS[(int)(numero - 10)];
        if (numero < 100) return DEZENAS[(int)(numero / 10)] + (numero % 10 > 0 ? " e " + UNIDADES[(int)(numero % 10)] : "");
        if (numero < 1000) return UNIDADES[(int)(numero / 100)] + " cento" + (numero % 100 > 0 ? " e " + converterParaExtenso(numero % 100) : "");
        if (numero < 1000000) return converterParaExtenso(numero / 1000) + " mil" + (numero % 1000 > 0 ? " " + converterParaExtenso(numero % 1000) : "");
        if (numero < 1000000000) return converterParaExtenso(numero / 1000000) + " milhão" + (numero % 1000000 > 0 ? " " + converterParaExtenso(numero % 1000000) : "");
        return converterParaExtenso(numero / 1000000000) + " bilhão" + (numero % 1000000000 > 0 ? " " + converterParaExtenso(numero % 1000000000) : "");
    }
}
