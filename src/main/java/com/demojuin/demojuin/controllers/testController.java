package com.demojuin.demojuin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/test")
public class testController {
    @GetMapping("/afficher")

    public String test(){
        return "Hey test";
    }
    @GetMapping("afficher2")

    public String test2(){
        return "Hey test2";
    }
}
