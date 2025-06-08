package com.demojuin.demojuin.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("api/user")
public class UserController {
    @GetMapping("afficher")

    public String user(){
        return "Hey user";
    }
    @GetMapping("user")
     public ResponseEntity<Map<String,Object>> getUser(){
          Map<String,Object> response =  new HashMap<>();
        response.put("status1","ok");
          response.put("status","success");
         List<String> users = new ArrayList<>();
         users.add("John");
         users.add("Mary");
         users.add("Jane");
         users.add("Mary");
        Set<String> users1 = new HashSet<>();
        users1.add("John");
        users1.add("Mary");
        users1.add("Jane");
        users1.add("Mary");
         response.put("data",users);
        response.put("data2",users1);
        response.put("status2","conflict");
         return ResponseEntity.ok(response);

     }
}
