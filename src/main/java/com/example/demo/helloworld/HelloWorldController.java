package com.example.demo.helloworld;

import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//rest api 

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // / hello-world
    @RequestMapping(path = "/hello-world", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello World!!!";
    }

    @RequestMapping(path = "/hello-world-bean", method = RequestMethod.GET)
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World!!!");
    }

    @RequestMapping(path = "/hello-world/path-variable/{name}", method = RequestMethod.GET)
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean("Hello World," + name);
    }

    @RequestMapping(path = "/hello-world-i18n", method = RequestMethod.GET)
    public String helloWorldI18n() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "default msg", locale);
        // return "Hello World v2!!!";
    }
}