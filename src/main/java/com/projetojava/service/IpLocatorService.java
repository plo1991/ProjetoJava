package com.projetotestejava.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.projetotestejava.dto.IpInfoResponse;

@Service
public class IpLocatorService {
    private final RestTemplate restTemplate = new RestTemplate();
    
    public IpInfoResponse localizarIp(String ip) {
        try {
            String url = "https://ipinfo.io/" + ip + "?token=freeplan";
            IpInfoResponse response = restTemplate.getForObject(url, IpInfoResponse.class);
            return response;
        } catch (Exception e) {
            IpInfoResponse erro = new IpInfoResponse();
            erro.setIp(ip);
            return erro;
        }
    }
}
