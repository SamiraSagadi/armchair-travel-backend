package com.armChairTraveller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class UserService {

    Scanner scanner = new Scanner(System.in);
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getFullListUser() {
        for (User user : userRepository.findAll()) {
            System.out.println(user);
        }
        return userRepository.findAll();
    }

    public void addNewUser(User newUser) {
        userRepository.findUserByEmail(newUser.getEmail())
                .ifPresentOrElse(user -> {
                    throw new IllegalStateException("Person with this email address: " + newUser.getEmail() + " is already registered.");
                }, () -> {
                    if (
                                    newUser.getFirstName() != null &&
                                    newUser.getLastName() != null &&
                                    newUser.getEmail() != null &&
                                            newUser.getPassword() != null
                    ){
                        userRepository.save(newUser);
                    }
                    else {
                        throw new IllegalStateException("All information must be provided!");
                    }
                });
    }

    public void deleteUser(String userEmail){
      userRepository.findUserByEmail(userEmail).ifPresent(userRepository::delete);
    }


}

