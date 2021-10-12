package com.armChairTraveller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/users")
@RestController
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> listUser(){
        return userService.getFullListUser();
    }

    @PostMapping(value = "addUser")
    public void addNewUser(@RequestBody User newUser){
        userService.addNewUser(newUser);
    }

}
