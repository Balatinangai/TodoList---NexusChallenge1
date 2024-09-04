package com.example.todolist.service; // Pacote onde o serviço está localizado

import com.example.todolist.dto.LoginRequest; // Importa a classe LoginRequest para obter informações de login
import com.example.todolist.model.User; // Importa a classe User que representa o modelo de usuário
import com.example.todolist.repository.UserRepository; // Importa o repositório de usuário para acessar dados do banco
import io.jsonwebtoken.Jwts; // Importa Jwts para criar e parsear JWT
import io.jsonwebtoken.SignatureAlgorithm; // Importa SignatureAlgorithm para o algoritmo de assinatura
import org.springframework.beans.factory.annotation.Value; // Importa Value para ler propriedades do arquivo de configuração
import org.springframework.stereotype.Service; // Importa Service para marcar a classe como um serviço

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey; // Chave secreta para assinar o JWT

    private final UserRepository userRepository; // Repositório de usuário para buscar dados de usuário

    // Construtor para injeção de dependências
    public JwtService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String generateToken(LoginRequest loginRequest) {
        // Busca o usuário no banco de dados pelo nome de usuário fornecido
        User user = userRepository.findByUsername(loginRequest.getUsername());
        
        // Verifica se o usuário foi encontrado e se a senha corresponde
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            // Cria e retorna o JWT
            return Jwts.builder()
                .setSubject(user.getUsername()) // Define o assunto do token (nome de usuário)
                .signWith(SignatureAlgorithm.HS256, secretKey) // Define o algoritmo de assinatura e a chave secreta
                .compact(); // Compacta o JWT para string
        } else {
            throw new RuntimeException("Invalid credentials"); // Lança exceção se credenciais forem inválidas
        }
    }
}
