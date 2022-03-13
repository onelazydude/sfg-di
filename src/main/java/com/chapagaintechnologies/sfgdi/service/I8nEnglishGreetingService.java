package com.chapagaintechnologies.sfgdi.service;

import com.chapagaintechnologies.sfgdi.repository.EnglishGreetingRepository;

public class I8nEnglishGreetingService implements GreetingService{

    private final EnglishGreetingRepository englishGreetingRepository;

    public I8nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }
}
