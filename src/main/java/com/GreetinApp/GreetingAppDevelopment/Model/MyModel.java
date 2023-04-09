package com.GreetinApp.GreetingAppDevelopment.Model;

import com.GreetinApp.GreetingAppDevelopment.DTO.MyDto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.yaml.snakeyaml.events.Event;

public class MyModel {

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    @Id
    @GeneratedValue
    private long Id;
    private String firstName;
    private String lastName;
    private String greeting;
}

