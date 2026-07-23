package com.projetotestejava.service;

import org.springframework.stereotype.Service;
import com.projetotestejava.dto.EmailValidationResponse;
import java.util.regex.Pattern;

@Service
public class EmailValidationService {
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    
    public EmailValidationResponse validar(String email) {
        boolean valido = pattern.matcher(email).matches();
        String mensagem = valido ? "Email válido" : "Email inválido";
        return new EmailValidationResponse(email, valido, mensagem);
    }
}
