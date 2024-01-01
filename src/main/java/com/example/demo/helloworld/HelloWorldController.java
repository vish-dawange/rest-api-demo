package com.example.demo.helloworld;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//rest api 

@RestController
public class HelloWorldController {

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
}