package com.practicewithdcb.user.controller;

import com.practicewithdcb.user.VO.ResponseTemplateVO;
import com.practicewithdcb.user.entity.User;
import com.practicewithdcb.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside the saveUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment( @PathVariable("id") Long userId){
        log.info("Inside the getUserWithDepartment method of UserController");
        return userService.getUserWithDepartment(userId);
    }

}
