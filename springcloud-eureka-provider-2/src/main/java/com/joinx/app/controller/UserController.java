package com.joinx.app.controller;

import com.joinx.app.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
   @GetMapping("/getUser/{id}")
   public User getUser(@PathVariable long id){
      System.out.println("asdfgfhdfgsdfsSDd");
      User user=new User();
      user.setName("joinx");
      user.setID(1l);
      return user;
   }
}
