package dev.sternschnuppe.thirdbasic.boundary.controller;

import dev.sternschnuppe.thirdbasic.boundary.model.UserDto;
import dev.sternschnuppe.thirdbasic.jpa.entity.UserEntity;
import dev.sternschnuppe.thirdbasic.jpa.repository.UserRepository;
import dev.sternschnuppe.thirdbasic.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(
            UserService userService,
            @Autowired UserRepository userRepository,
            @Autowired PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @ResponseBody
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(null);
    }

    @ResponseBody
    @GetMapping("{id}")
    public ResponseEntity<UserDto> readUser(@PathVariable("id") Long id){
        return ResponseEntity.ok(null);
    }

    @ResponseBody
    @GetMapping
    public ResponseEntity<List<UserDto>> readUserAll(){
        return ResponseEntity.ok(null);
    }

    @ResponseBody
    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(null);
    }

    @ResponseBody
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("login")
    public String login(){
        return "login-form";
    }

    @GetMapping("signup")
    public String signUp(){
        return "signup-form";
    }

    @PostMapping("signup")
    public String signUpPost(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("password_check") String passwordCheck
    ){
        if (!password.equals(passwordCheck)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        UserEntity newUser = new UserEntity();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        userRepository.save(newUser);

        return "redirect:/home";
    }
}
