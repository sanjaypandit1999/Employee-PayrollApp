package com.bridgelabz.employeepayrollapp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class AppConfiguration {
	@Bean
	public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}
