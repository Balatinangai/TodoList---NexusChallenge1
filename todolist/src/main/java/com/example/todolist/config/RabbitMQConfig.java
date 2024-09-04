package com.example.todolist.config; // Pacote onde a configuração está localizada

import org.springframework.amqp.core.Queue; // Importa a classe Queue para definir uma fila no RabbitMQ
import org.springframework.context.annotation.Bean; // Importa a anotação @Bean para definir um bean no contexto do Spring
import org.springframework.context.annotation.Configuration; // Importa a anotação @Configuration para marcar a classe como uma classe de configuração

@Configuration // Indica que esta classe contém métodos de configuração que serão usados pelo Spring para configurar o contexto da aplicação
public class RabbitMQConfig {

    // Define um bean do tipo Queue que será gerenciado pelo Spring
    @Bean
    public Queue taskQueue() {
        // Cria e retorna uma nova instância de Queue com o nome "taskQueue"
        // O segundo parâmetro indica se a fila é durável. false significa que a fila não é durável e será excluída quando o RabbitMQ reiniciar
        return new Queue("taskQueue", false);
    }
}
