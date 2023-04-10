package com.GreetinApp.GreetingAppDevelopment.Controller;

import com.GreetinApp.GreetingAppDevelopment.DTO.MyDto;
import com.GreetinApp.GreetingAppDevelopment.Model.MyModel;
import com.GreetinApp.GreetingAppDevelopment.Repository.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Service
public class MyController {
    @Autowired
    private MyRepo myRepo;
    public List<MyModel>getalldata(){
        List<MyModel>data=new ArrayList<>();
        myRepo.findAll().forEach(datas ->data.add(datas));
        return data;
    }
    @PutMapping("/put/{id}")
    public MyModel update(@RequestBody MyDto myDto,@PathVariable long id){
        Optional<MyModel>data=myRepo.findById(id);
        if (data.isPresent()){
            data.get().setFirstName(myDto.firstName);
            data.get().setLastName(myDto.lastName);
            data.get().setGreeting(myDto.greeting);
        }
        return null;
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