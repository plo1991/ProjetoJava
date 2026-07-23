package com.projetotestejava.service;

import org.springframework.stereotype.Service;
import java.util.Random;
import com.projetotestejava.dto.PersonResponse;

@Service
public class PersonGenerator {
    private static final String[] NOMES = {"Ana Silva", "Bruno Santos", "Carlos Mendes", "Diana Costa", "Eduardo Ferreira", 
        "Fernanda Oliveira", "Gabriel Souza", "Helena Martins", "Igor Pereira", "Juliana Rocha"};
    private static final String[] CIDADES = {"São Paulo", "Rio de Janeiro", "Belo Horizonte", "Curitiba", "Salvador"};
    private static final String[] ESTADOS = {"SP", "RJ", "MG", "PR", "BA"};
    
    private Random random = new Random();
    
    public PersonResponse gerarPessoa() {
        PersonResponse pessoa = new PersonResponse();
        String nome = NOMES[random.nextInt(NOMES.length)];
        
        pessoa.setNome(nome);
        pessoa.setEmail(nome.toLowerCase().replace(" ", ".") + "@email.com");
        pessoa.setTelefone("11-9" + String.format("%07d", random.nextInt(10000000)));
        pessoa.setCpf(gerarCpfValido());
        pessoa.setDataNascimento(String.format("%02d/%02d/%04d", 
            1 + random.nextInt(28), 1 + random.nextInt(12), 1970 + random.nextInt(50)));
        pessoa.setEndereco("Rua " + String.format("%04d", random.nextInt(10000)));
        pessoa.setCidade(CIDADES[random.nextInt(CIDADES.length)]);
        pessoa.setEstado(ESTADOS[random.nextInt(ESTADOS.length)]);
        pessoa.setCep(String.format("%05d", random.nextInt(100000)) + "-" + String.format("%03d", random.nextInt(1000)));
        
        return pessoa;
    }
    
    private String gerarCpfValido() {
        int[] cpf = new int[11];
        for (int i = 0; i < 9; i++) {
            cpf[i] = random.nextInt(10);
        }
        
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += cpf[i] * (10 - i);
        }
        int resto = soma % 11;
        cpf[9] = resto < 2 ? 0 : 11 - resto;
        
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += cpf[i] * (11 - i);
        }
        resto = soma % 11;
        cpf[10] = resto < 2 ? 0 : 11 - resto;
        
        return String.format("%03d.%03d.%03d-%02d", cpf[0] * 100 + cpf[1] * 10 + cpf[2],
            cpf[3] * 100 + cpf[4] * 10 + cpf[5], cpf[6] * 100 + cpf[7] * 10 + cpf[8],
            cpf[9] * 10 + cpf[10]);
    }
}
