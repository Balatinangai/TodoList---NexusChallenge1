package com.example.todolist.controller; // Pacote onde o controlador está localizado

import com.example.todolist.dto.LoginRequest; // Importa a classe DTO para solicitação de login
import com.example.todolist.dto.RegisterRequest; // Importa a classe DTO para solicitação de registro
import com.example.todolist.service.UserService; // Importa o serviço de usuário para lógica de negócios
import com.example.todolist.service.JwtService; // Importa o serviço JWT para geração e validação de tokens
import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação para injeção de dependência
import org.springframework.web.bind.annotation.*; // Importa as anotações para criar endpoints REST

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/api/auth") // Define o caminho base para todos os endpoints neste controlador
public class AuthController {

    @Autowired // Injeta automaticamente a dependência do UserService
    private UserService userService;

    @Autowired // Injeta automaticamente a dependência do JwtService
    private JwtService jwtService;

    // Endpoint para registrar um novo usuário
    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest registerRequest) {
        // Chama o serviço de usuário para registrar um novo usuário usando as informações fornecidas
        userService.registerUser(registerRequest);
    }

    // Endpoint para fazer login e obter um token JWT
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // Chama o serviço JWT para gerar um token com base nas credenciais fornecidas
        return jwtService.generateToken(loginRequest);
    }
}
