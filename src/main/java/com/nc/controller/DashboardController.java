package com.nc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nc.mapper.DashboardMapper;
import com.nc.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin("*")
public class DashboardController {
    @Autowired
    private DashboardMapper dashboardMapper;
    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllUser(){
        List<Map<String,String>> data;
        try {
            data=dashboardMapper.getAll();
        }catch (Exception e){
            data=new ArrayList<>();
        }
        return ResponseEntity.ok(mapper.createObjectNode().putPOJO("data",data));
    }

}
