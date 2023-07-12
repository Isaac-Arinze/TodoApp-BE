package com.zikan.todomanagementproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoAppProjectApplication {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoAppProjectApplication.class, args);
    }

}
