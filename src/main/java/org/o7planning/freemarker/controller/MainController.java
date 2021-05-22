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
    public UserDto getUser(@PathVariable(name = "id") Long id) {

        UserEntity user = userService.getUsers().get(id);

        return new UserDto(user);
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/{id}m")
    public ResponseEntity<?> modifyUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        userService.modifyUser(id, userDto);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value="/user_delete")
    public void deleteUser(@RequestParam(value = "id", required = true) Long id) {
        userService.deleteUser(id);
    }

}