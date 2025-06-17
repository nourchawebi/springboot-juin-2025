package com.demojuin.demojuin.controllers;

import com.demojuin.demojuin.entities.UserEntity;
import com.demojuin.demojuin.services.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserInterface userInterface;
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
     @PostMapping("add")
     public UserEntity addUser(@RequestBody UserEntity user){
       return userInterface.adduser(user);
     }
     @DeleteMapping("delete/{id}")
      public void deleteUser( @PathVariable Long id){
        userInterface.deletedUser(id);
      }
      @DeleteMapping("delete")
      public void deleteusers(@RequestParam("a") Long i){
          userInterface.deletedUser(i);
      }
      @PostMapping("saveall")
      public List<UserEntity> addListUsers(@RequestBody List<UserEntity> users){
        return userInterface.AddListUsers(users);
      }
       @PostMapping("addwithconfpassword")
       public  String addUserWithConfPassword(@RequestBody UserEntity user){
        return userInterface.addUserWTCP(user);
       }
       @PostMapping("addWTUN")
    public String  addUserWTUN(@RequestBody UserEntity user){
        return userInterface.addUserWTUN(user);
       }
       @PutMapping("updateuser/{id}")
        public UserEntity updateUser(@PathVariable Long id,@RequestBody UserEntity user){
         return userInterface.UpdateUser(user , id);
       }
     @GetMapping("all")
      public List<UserEntity> getAllUsers(){
         return userInterface.getAllUsers();
     }
     @GetMapping("findbyusername/{abc}")
    public UserEntity getUserByUsername(@PathVariable("abc") String u){
        return userInterface.getUserByUsername(u);
     }
     @GetMapping("getuserswt/{cle}")
    public List<UserEntity> getUserSW(@PathVariable String cle){
        return userInterface.getUsersSWT(cle);

     }
     @GetMapping("getuserbyemaildomaine")
    public List<UserEntity> getUserByEmailDomaine(@RequestParam String email){
        return userInterface.getUserByEmail(email);
     }
}
