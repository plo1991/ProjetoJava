package com.projetotestejava.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.projetotestejava.dto.MoneyConversionResponse;
import java.util.Map;

@Service
public class CurrencyConverterService {
    private final RestTemplate restTemplate = new RestTemplate();
    
    public MoneyConversionResponse converter(String de, String para, double valor) {
        try {
            String url = "https://api.exchangerate-api.com/v4/latest/" + de.toUpperCase();
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            
            if (response != null && response.containsKey("rates")) {
                Map<String, Double> rates = (Map<String, Double>) response.get("rates");
                double taxa = rates.getOrDefault(para.toUpperCase(), 1.0);
                return new MoneyConversionResponse(de.toUpperCase(), para.toUpperCase(), valor, taxa);
            }
        } catch (Exception e) {
            // Retornar taxa padrão em caso de erro
        }
        return new MoneyConversionResponse(de.toUpperCase(), para.toUpperCase(), valor, 1.0);
    }
}
