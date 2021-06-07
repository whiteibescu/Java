package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserDto;
import com.example.demo.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController// rest api
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers(@RequestParam(required = false) Long level) {
        return userService.findAllBy(level);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User postUser(@RequestBody User reqUser) {
        return userService.save(reqUser);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public User putUserById(@PathVariable Long id, @RequestBody User reqUser) {
        reqUser.setId(id);
        return userService.save(reqUser);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public UserDto.Deleted deleteUserById(@PathVariable Long id) {
        if (userService.delete(id)) {
            return new UserDto.Deleted(id);
        } else {
            throw new IllegalArgumentException("존재하지 않는 사용자입니다.");
        }
    }
}