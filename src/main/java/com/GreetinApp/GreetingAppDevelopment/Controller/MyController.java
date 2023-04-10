package com.GreetinApp.GreetingAppDevelopment.Controller;

import com.GreetinApp.GreetingAppDevelopment.DTO.MyDto;
import com.GreetinApp.GreetingAppDevelopment.Model.MyModel;
import com.GreetinApp.GreetingAppDevelopment.Repository.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MyController {
    @Autowired
    private MyRepo myRepo;
    public List<MyModel>getalldata(){
        List<MyModel>data=new ArrayList<>();
        myRepo.findAll().forEach(datas ->data.add(datas));
        return data;
    }
    public void save(MyModel data){
        myRepo.save(data);
    }
    @GetMapping("/get")
    public List<MyModel>getall(){
        return getalldata();
    }
    @PostMapping("/hello")
    public MyModel addEmployee(@RequestBody MyDto myDto){
        MyModel data=new MyModel(myDto);
        return myRepo.save(data);
        }

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello world";
    }
    @GetMapping("/{id}")
    public String getEmployee(@PathVariable long id) {
        Optional<MyModel> data = myRepo.findById(id);
        String greeting = "data is not found";
        if (data.isPresent()) {
            greeting = data.get().getFirstName() + data.get().getLastName() + data.get().getGreeting();
        }
        return greeting;
    }

}