package com.stacksimplify.restservices.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {
    @Autowired
    ResourceBundleMessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET, path = "/helloworld")
    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/person")
    public Person getPerson() {
        return Person.builder().firstName("Ash").lastName("Jam").city("Sydney").build();
    }

    @GetMapping("/hello-int")
    public String getMessagesInI18nFormat(@RequestHeader(name = "Accept-Language", required = false) String locale) {
        return messageSource.getMessage("label.hello",null, new Locale(locale));
    }

    @GetMapping("/hello-int2")
    public String getMessagesInI18nFormat2() {
        return messageSource.getMessage("label.hello",null, LocaleContextHolder.getLocale());
    }

}
