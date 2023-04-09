package com.GreetinApp.GreetingAppDevelopment.Controller;

import com.GreetinApp.GreetingAppDevelopment.DTO.MyDto;
import com.GreetinApp.GreetingAppDevelopment.Model.MyModel;
import com.GreetinApp.GreetingAppDevelopment.Repository.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MyController {
    @Autowired
    private MyRepo myRepo;

    @PostMapping("/hello")
    public MyModel addEmployee(@RequestBody MyDto myDto){
        MyModel data=new MyModel(myDto);
        return myRepo.save(data);
        }

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello world";
    }
}