package com.sms.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("com.sms")
@EnableWebMvc
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {

public <T> void configurerMessageConverters(List<HttpMessageConverter<T>> converters) {
	Jackson2ObjectMapperBuilder builder=new Jackson2ObjectMapperBuilder();
	builder.indentOutput(true);
	converters.add((HttpMessageConverter<T>) new MappingJackson2HttpMessageConverter(builder.build()));
}
}
