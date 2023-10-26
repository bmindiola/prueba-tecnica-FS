package com.test.clientinfo.infrastructure.entities;

import com.test.clientinfo.infrastructure.repositories.ClientInfoJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitialization {
    private final ClientInfoJpaRepository clientInfoJpaRepository;

    public DataInitialization(ClientInfoJpaRepository clientInfoJpaRepository) {
        this.clientInfoJpaRepository = clientInfoJpaRepository;
    }

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            ClientInfoEntity clientInfo = new ClientInfoEntity.ClientInfoEntityBuilder()
                    .id(1L)
                    .documentType("C")
                    .documentNumber("23445322")
                    .firstName("Carlos")
                    .secondName("Andres")
                    .firstSurname("Mendoza")
                    .secondSurname("Jaimes")
                    .phone("3008445679")
                    .address("Cra. 8 #7 - 26, La Candelaria")
                    .cityResidence("Bogotá")
                    .build();

            clientInfoJpaRepository.save(clientInfo);
        };
    }
}
