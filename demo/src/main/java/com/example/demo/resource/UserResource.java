package com.example.demo.resource;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    public void create(@RequestBody UserDTO userDTO) {
        this.userService.createUser(userDTO);
    }
}
