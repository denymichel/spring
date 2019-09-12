package com.consultorio.consultorio;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j

public class cargadobd {
    @Bean
    CommandLineRunner initDatabase(Repositorio_Consul repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Consultorio("12", "planta baja", "pediatria")));
            log.info("Preloading " + repository.save(new Consultorio ("13", "planta baja", "medicina general")));
            log.info("Preloading " + repository.save(new Consultorio ("5", "primer piso", "urologia")));
            log.info("Preloading " + repository.save(new Consultorio ("5", "primer piso", "ginecologia")));

        };
    } }