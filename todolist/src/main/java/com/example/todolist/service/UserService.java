package com.example.todolist.service;

import com.example.todolist.dto.RegisterRequest; // Importa o DTO para o registro de usuários
import com.example.todolist.model.User; // Importa a classe User, que representa a entidade de usuário
import com.example.todolist.repository.UserRepository; // Importa o repositório de usuários para interagir com o banco de dados
import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação para injeção de dependências
import org.springframework.security.core.userdetails.UserDetailsService; // Importa a interface UserDetailsService para integração com Spring Security
import org.springframework.security.core.userdetails.UsernameNotFoundException; // Importa a exceção lançada quando o usuário não é encontrado
import org.springframework.stereotype.Service; // Importa a anotação para marcar a classe como um serviço
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; // Repositório para acessar dados de usuário

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Método para registrar um novo usuário
    public void registerUser(RegisterRequest registerRequest) {
        User user = new User(); // Cria uma nova instância de User
        user.setUsername(registerRequest.getUsername()); // Define o nome de usuário
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword())); // Criptografa a senha
        userRepository.save(user); // Salva o usuário no banco de dados
    }

    // Método da interface UserDetailsService para carregar o usuário pelo nome de usuário
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username); // Busca o usuário pelo nome de usuário
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username); // Lança exceção se o usuário não for encontrado
        }
        return user; // Retorna o usuário encontrado
    }
}
