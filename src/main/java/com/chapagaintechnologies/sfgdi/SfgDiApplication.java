package com.chapagaintechnologies.sfgdi;

import com.chapagaintechnologies.sfgdi.controller.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.chapagaintechnologies.sfgdi","com.chapagaintechnologies.external"})
@SpringBootApplication
public class SfgDiApplication {

    public static void main(String[] args) {
        // This is the way we grab Application Context.
        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);
        MyController myController = (MyController) ctx.getBean("myController");
        // this myController is the name of the bean "MyController" by default, unless you specify a name
        String greeting = myController.sayHello();
        System.out.println(greeting);
        System.out.println("-------------------");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());
        System.out.println("------------------- property");

        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());
        System.out.println("------------------- setter");

        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());
        System.out.println("------------------- constructor");

        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayGreeting());
       /* propertyInjectedController.greetingService = new GreetingServiceImpl();

        SetterInjectedController setterInjectedController = new SetterInjectedController();
        setterInjectedController.setGreetingService(new GreetingServiceImpl());

        ConstructorInjectedController constructorInjectedController = new ConstructorInjectedController(new GreetingServiceImpl());
        */
    }

}
