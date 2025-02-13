package br.com.alex.ms.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.MessageConverter;

@Configuration
public class RabbitConfiguration {

    @Bean
    public MessageConverter jackson2JsonMessageConverter(ObjectMapper customeObjectMapper) {
        return new Jackson2JsonMessageConverter(customeObjectMapper);

    }
}
