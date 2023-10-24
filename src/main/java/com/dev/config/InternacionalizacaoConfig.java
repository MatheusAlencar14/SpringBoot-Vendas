package com.dev.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class InternacionalizacaoConfig {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("classpath:messages"); //Indica o nome do arquivo a ser utilizado
        ms.setDefaultEncoding("ISO-8859-1"); //Indica em que codificação estão as mensagens
        ms.setDefaultLocale(Locale.getDefault()); //Indica o local onde a apliação está sendo rodada
        return ms;
    }

    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean() {
        LocalValidatorFactoryBean vfb = new LocalValidatorFactoryBean();
        vfb.setValidationMessageSource(messageSource());
        return vfb;
    }
}
