package com.stacksimplify.restservices.springbootbuildingblocks;

import com.stacksimplify.restservices.config.AppConfig;
import com.stacksimplify.restservices.exceptions.CustomGlobalExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@SpringBootApplication
@ComponentScan(basePackages = "com.stacksimplify.restservices")
@EnableJpaRepositories(basePackages = "com.stacksimplify.restservices.repositories")
@EntityScan(basePackages = {"com.stacksimplify.restservices.entities"})
@Import({CustomGlobalExceptionHandler.class, AppConfig.class})
//@Import({GlobalRestControllerAdviceExceptionHandler.class})
public class SpringbootBuildingblocksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBuildingblocksApplication.class, args);
    }

    @Bean
    public LocaleResolver localResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
}
