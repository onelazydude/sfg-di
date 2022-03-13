package com.chapagaintechnologies.sfgdi.service;


public class ConstructorGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World from constructor";
    }
}
