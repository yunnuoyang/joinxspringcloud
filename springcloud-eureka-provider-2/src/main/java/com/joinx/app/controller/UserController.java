package com.joinx.app.controller;

import com.joinx.app.pojo.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
   @GetMapping("/getUser/{id}")
   public User getUser(@PathVariable long id){
      System.out.println("asdfgfhdfgsdfsSDd");
      User user=new User();
      user.setName("joinx");
      user.setID(id);
      return user;
   }
   @PostMapping("/addUser")
   public User addUser(@RequestBody User user){
      System.out.println(user.getID()+"===="+user.getName());
   
      return user;
   }
}
