package com.lazylad.expensetrackerapi.controller;

import com.lazylad.expensetrackerapi.domain.User;
import com.lazylad.expensetrackerapi.domain.UserDetailsDTO;
import com.lazylad.expensetrackerapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDetailsDTO> registerUser(@RequestBody Map<String, Object> userMap) {
        String firstName = (String) userMap.get("firstName");
        String lastName = (String) userMap.get("lastName");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");

        User user = userService.registerUser(firstName, lastName, email, password);


        return ResponseEntity.ok(user.toUserDetailsDTO());
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<User[]> getUsers(@RequestParam(defaultValue = "50") Integer limit) {
        return ResponseEntity.ok(userService.findAllUsers(limit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    ;
}
