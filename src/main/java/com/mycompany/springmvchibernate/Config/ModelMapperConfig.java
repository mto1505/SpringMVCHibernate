/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.Config;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mycompany.springmvchibernate.CustomDeserialize.CustomDateDeserializer;


import java.io.FileDescriptor;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 *
 * @author MinhTo
 */
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper;
    }
    @Bean
    @Primary
    public ObjectMapper objectMapper(){
        ObjectMapper objectMapper=new ObjectMapper();
    
        //objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
//        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
//        objectMapper.configOverride(FileDescriptor.class)
//        .setIsIgnoredType(true);
        return objectMapper;
    }
}
