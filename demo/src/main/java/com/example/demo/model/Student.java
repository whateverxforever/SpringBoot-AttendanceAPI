package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Student {

    private final String id;
    private final String name;

    public Student(@JsonProperty("id") String id,
                   @JsonProperty("name") String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }
}
