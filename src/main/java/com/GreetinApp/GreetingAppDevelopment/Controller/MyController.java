package com.GreetinApp.GreetingAppDevelopment.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/greeting")
    public String greeting(){
        return "Greeting App Development";
    }
}
