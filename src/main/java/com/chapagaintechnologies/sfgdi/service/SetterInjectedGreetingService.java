package com.chapagaintechnologies.sfgdi.service;

import org.springframework.stereotype.Service;

public class SetterInjectedGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello World from setter";
    }
}
