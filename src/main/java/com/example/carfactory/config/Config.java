package com.example.carfactory.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Set;

@Configuration
@EnableScheduling
public class Config {

    @Bean
    public ModelMapper modelMapper(Set<Converter> converterSet) {
        ModelMapper modelMapper = new ModelMapper();
        converterSet.forEach(modelMapper::addConverter);

        return modelMapper;
    }

}
