package com.chapagaintechnologies.sfgdi.controller;

import com.chapagaintechnologies.sfgdi.service.GreetingService;

public class PropertyInjectedController {
    public GreetingService greetingService;

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
