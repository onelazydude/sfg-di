package com.chapagaintechnologies.sfgdi.config;

import com.chapagaintechnologies.datasource.AnotherMockDatabase;
import com.chapagaintechnologies.datasource.FakeDataSource;
import com.chapagaintechnologies.sfgdi.repository.EnglishGreetingRepository;
import com.chapagaintechnologies.sfgdi.repository.EnglishGreetingRepositoryImpl;
import com.chapagaintechnologies.sfgdi.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

       /* @Bean
        ConstructorGreetingService constructorGreetingService(){
            return new ConstructorGreetingService();
        }*/

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

        @Bean
        FakeDataSource fakeDataSource(@Value("${fake.username}") String username, @Value("${fake.password}") String password, @Value("${fake.jdbcurl}") String jdbcurl){
            FakeDataSource fakeSource = new FakeDataSource();
            fakeSource.setUsername(username);
            fakeSource.setPassword(password);
            fakeSource.setJdbcurl(jdbcurl);
            return fakeSource;
        }

        @Bean
        AnotherMockDatabase anotherMockDatabase(@Value("${mock.username}") String username, @Value("${mock.password}") String password, @Value("${mock.jdbcurl}") String jdbcurl){
            AnotherMockDatabase mockDatabase = new AnotherMockDatabase();
            mockDatabase.setUsername(username);
            mockDatabase.setPassword(password);
            mockDatabase.setJdbcurl(jdbcurl);
            return mockDatabase;
        }
}
