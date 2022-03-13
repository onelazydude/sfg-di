package com.chapagaintechnologies.sfgdi.config;

import com.chapagaintechnologies.sfgdi.repository.EnglishGreetingRepository;
import com.chapagaintechnologies.sfgdi.repository.EnglishGreetingRepositoryImpl;
import com.chapagaintechnologies.sfgdi.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

        @Bean
        ConstructorGreetingService constructorGreetingService(){
            return new ConstructorGreetingService();
        }

        @Bean
        PropertyInjectedGreetingService propertyInjectedGreetingService(){
            return new PropertyInjectedGreetingService();
        }

        @Bean
        EnglishGreetingRepository englishGreetingRepository(){
            return new EnglishGreetingRepositoryImpl();
        }

        @Bean
        SetterInjectedGreetingService setterInjectedGreetingService(){
            return new SetterInjectedGreetingService();
        }

        @Primary
        @Bean
        PrimaryGreetingService primaryGreetingService(){
            return new PrimaryGreetingService();
        }

        @Profile("EN")
        @Bean
        I8nEnglishGreetingService i8nGreetingService(EnglishGreetingRepository englishGreetingRepository){
            return new I8nEnglishGreetingService(englishGreetingRepository);
        }

        @Profile({"ES","default"})
        @Bean
        I8nSpanishGreetingService i8nSpanishGreetingService(){
            return new I8nSpanishGreetingService();
        }

        @Bean
        PetServiceFactory petServiceFactory(){
            return new PetServiceFactory();
        }

        @Profile("cat")
        @Bean
        PetService dogPetService(PetServiceFactory petServiceFactory){
            return petServiceFactory().getPetService("dog");
        }

        @Profile({"dog", "default"})
        @Bean
        PetService catPetService(PetServiceFactory petServiceFactory){
            return petServiceFactory().getPetService("cat");
        }
}
