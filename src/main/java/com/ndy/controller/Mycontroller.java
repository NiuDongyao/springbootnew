package com.ndy.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mycontroller {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

}
