package com.backend.back.controller;

import com.backend.back.dto.UserDto;
import com.backend.back.exception.CustomException;
import com.backend.back.mapper.StudentMapper;
import com.backend.back.model.Student;
import com.backend.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserDto userDto) {
        try {
            UserDto newUserDto = userService.signup(userDto);
            return ResponseEntity.status(HttpStatus.OK).body(newUserDto);
        }
        catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity login(@PathVariable String email, @PathVariable String password) {
        try {
            UserDto userDto = userService.login(email, password);
            return ResponseEntity.status(HttpStatus.OK).body(userDto);
        }
        catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
}
