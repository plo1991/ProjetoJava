package com.projetotestejava.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.projetotestejava.dto.CepResponse;

@Service
public class CepService {
    private static final String VIACEP_URL = "https://viacep.com.br/ws/{cep}/json/";
    
    private final RestTemplate restTemplate;
    
    public CepService() {
        this.restTemplate = new RestTemplate();
    }
    
    public CepResponse buscarCep(String cep) {
        // Remover caracteres especiais
        String cepLimpo = cep.replaceAll("[^0-9]", "");
        
        if (cepLimpo.length() != 8) {
            CepResponse erro = new CepResponse();
            erro.setErro(true);
            return erro;
        }
        
        try {
            String url = VIACEP_URL.replace("{cep}", cepLimpo);
            CepResponse response = restTemplate.getForObject(url, CepResponse.class);
            return response;
        } catch (Exception e) {
            CepResponse erro = new CepResponse();
            erro.setErro(true);
            return erro;
        }
    }
}
