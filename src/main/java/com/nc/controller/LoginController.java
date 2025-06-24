package com.nc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nc.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private LoginMapper loginMapper;
    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/login")
    public ResponseEntity login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        boolean isExist = false;
        try {
            isExist = loginMapper.isUserExist(userName, password);
        } catch (Exception e) {
            isExist = false;
        }
        if (isExist) {
            return ResponseEntity.ok(mapper.createObjectNode().put("isExist", true));
        } else {
            return ResponseEntity.ok(mapper.createObjectNode().put("isExist", false));
        }
    }
}
