package com.av.coffee_machine;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@SpringBootApplication
public class CoffeeMachineApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeMachineApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        /*
         Задаем стратегию. Включаем сопоставление полей. Задаем приватный уровень доступа к полям.
         */
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(PRIVATE);
        return mapper;
    }
}
