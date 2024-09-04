package com.example.todolist.config; // Pacote onde a configuração de segurança está localizada

import com.example.todolist.service.JwtService; // Importa o serviço JWT para geração e validação de tokens
import com.example.todolist.service.UserService; // Importa o serviço de usuário para autenticação
import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação @Autowired para injeção de dependências
import org.springframework.context.annotation.Bean; // Importa a anotação @Bean para definir beans no contexto do Spring
import org.springframework.context.annotation.Configuration; // Importa a anotação @Configuration para marcar a classe como uma classe de configuração
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity; // Importa a classe HttpSecurity para configurar as permissões de acesso
import org.springframework.security.config.annotation.web.builders.AuthenticationManagerBuilder; // Importa a classe AuthenticationManagerBuilder para configurar o gerenciamento de autenticação
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; // Importa a anotação @EnableWebSecurity para habilitar a configuração de segurança
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; // Importa a classe WebSecurityConfigurerAdapter para configurar segurança personalizada
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; // Importa a classe UsernamePasswordAuthenticationFilter para configurar o filtro de autenticação padrão

@Configuration // Indica que esta classe contém métodos de configuração que serão usados pelo Spring para configurar o contexto da aplicação
@EnableWebSecurity // Habilita a configuração de segurança do Spring Security
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtService jwtService; // Serviço JWT para geração e validação de tokens

    @Autowired
    private UserService userService; // Serviço de usuário para autenticação e gerenciamento de usuários

    // Configura as permissões de acesso para diferentes endpoints
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // Desativa a proteção CSRF (Cross-Site Request Forgery) para permitir chamadas de API
            .authorizeRequests() // Configura as permissões de acesso
            .antMatchers("/api/auth/**").permitAll() // Permite acesso a todos os endpoints sob /api/auth/ sem autenticação
            .anyRequest().authenticated() // Requer autenticação para qualquer outra requisição
            .and()
            .addFilterBefore(new JwtAuthenticationFilter(jwtService, userService), UsernamePasswordAuthenticationFilter.class); // Adiciona um filtro personalizado para autenticação JWT antes do filtro de autenticação padrão
    }

    // Configura o gerenciamento de autenticação usando o UserService
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService); // Configura o UserService para fornecer detalhes do usuário
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
