package org.o7planning.freemarker.controller;

import org.o7planning.freemarker.Dto.UserDto;
import org.o7planning.freemarker.Service.UserService;
import org.o7planning.freemarker.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    public UserService userService;

    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable(name = "id") Long id) {

        UserEntity user = userService.getUsers().get(id);

        return new UserDto(user);
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok().build();
    }

}