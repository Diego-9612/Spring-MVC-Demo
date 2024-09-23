package com.diego.spring.springboot_web.controllers;


import java.util.*;

import org.springframework.web.bind.annotation.*;

import com.diego.spring.springboot_web.controllers.models.User;
import com.diego.spring.springboot_web.controllers.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/detailsMap")
    public Map <String, Object> detailsMap() {
        User user = new User("Diego", "Guerrero");
        Map<String, Object> body = new HashMap<>();
        body.put("Title", "Hola Diego con Spring Boot");
        body.put("user", user);
        return body;
    }

    @GetMapping("/detailsDto")
    public UserDto detailsDto() {

        UserDto userDto = new UserDto();
        User user = new User("Diego", "Guerrero");
        userDto.setUser(user);
        userDto.setTitle("Hola Diego con Spring Boot");
        
        return userDto;
    }

    @GetMapping("/list")
    public List<User> list (){
        User user = new User("Diego", "Guerrero");
        User user2 = new User("Nahomy", "Revelo");
        User user3 = new User("Andres", "Saa");

        List <User> users = Arrays.asList(user, user2, user3);
        //List <User> users = new ArrayList<>();
        //users.add(user);
        //users.add(user2);
        //users.add(user3);

        return users;

    }
}