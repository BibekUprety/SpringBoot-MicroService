package com.bibek.user.controller;

import com.bibek.user.VO.ResponseTemplateVO;
import com.bibek.user.entity.User;
import com.bibek.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user){
        log.info("user is created");
        return userService.saveUser(user);
    }
//
//    @GetMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public User getUser(@PathVariable Long id){
//        return userService.getUserById(id);
//    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable ("id") Long userId){
        return userService.getUserWithDepartment(userId);
    }
}
