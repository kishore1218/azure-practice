package com.example.springdockerexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {


    private static final String URL="http://backend-service.kishore.svc.cluster.local:8082/greetings";

    @GetMapping("/hello")
    public String hello(){

        return "Hello! Welcome";
    }

    @GetMapping("/greetings")
    public String greetings(){
        try{
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(URL, String.class);
            return result;
        }catch(Exception e){
            e.printStackTrace();
        }

        return "Hello";
    }
}
