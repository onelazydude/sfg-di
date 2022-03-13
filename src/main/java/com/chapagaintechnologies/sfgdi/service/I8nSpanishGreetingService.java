package com.chapagaintechnologies.sfgdi.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

public class I8nSpanishGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }
}
