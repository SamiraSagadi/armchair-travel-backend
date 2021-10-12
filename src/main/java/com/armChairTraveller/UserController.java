package com.armChairTraveller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/users")
@RestController
@CrossOrigin("*")
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

//    @PutMapping(path = "{userEmail}")
//    public void updateUser(@PathVariable("userEmail") String userEmail,
//                           @RequestBody User user){
//        userService.updateUser(userEmail, user);
//
//    }

    @DeleteMapping(path = "{userEmail}")
    public void deleteUser(@PathVariable("userEmail") String email ){
        userService.deleteUser(email);
    }
}
