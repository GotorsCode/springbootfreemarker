package org.o7planning.freemarker.controller;

import org.o7planning.freemarker.Dto.UserDto;
import org.o7planning.freemarker.Service.UserService;
import org.o7planning.freemarker.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    public UserService userService;

    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable(name = "id") Long id) throws Exception {

        return userService.getUser(id);
    }

    @PostMapping("/user")
    public Long createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        userService.modifyUser(id, userDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteUser(id);
    }

}