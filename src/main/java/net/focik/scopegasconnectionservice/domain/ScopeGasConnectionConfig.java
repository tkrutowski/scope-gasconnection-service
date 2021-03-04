package net.focik.scopegasconnectionservice.domain;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ScopeGasConnectionConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
