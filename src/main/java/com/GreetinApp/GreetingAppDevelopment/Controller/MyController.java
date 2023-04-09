package com.GreetinApp.GreetingAppDevelopment.Controller;

import com.GreetinApp.GreetingAppDevelopment.Model.MyModel;
import com.GreetinApp.GreetingAppDevelopment.Repository.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MyController {
    @Autowired
    private MyRepo myRepo;

    @GetMapping("/{id}")
    public String getEmployee(@PathVariable long id) {
        Optional<MyModel> data = myRepo.findById(id);
        String greeting = "Hello world";
        if (data.isPresent()) {
            greeting = data.get().getFirstName() + data.get().getLastName() + data.get().getGreeting();

        }
        return greeting;
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello world";
    }
}