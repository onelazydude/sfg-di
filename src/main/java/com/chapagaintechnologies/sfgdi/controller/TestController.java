package com.chapagaintechnologies.sfgdi.controller;

import com.chapagaintechnologies.external.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    @Autowired
    private TestService testService;

    private String sayHello(){
        return testService.test();
    }
}
