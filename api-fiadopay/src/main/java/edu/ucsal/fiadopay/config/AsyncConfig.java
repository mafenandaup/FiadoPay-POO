package edu.ucsal.fiadopay.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class AsyncConfig {

    @Bean(name = "paymentExecutor")
    public ExecutorService paymentExecutor() {
        // Aq basicamente cria um pool de threads fixo com 4 threads
        return Executors.newFixedThreadPool(4);
    }
}