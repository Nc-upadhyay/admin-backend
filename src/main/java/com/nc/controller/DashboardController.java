package com.nc.controller;

import com.fasterxml.jackson.databind.JsonNode;
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

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody JsonNode node){
        int result=0;
        try {
            int id=node.get("sNo").asInt();
            String name=node.get("name").asText();
            String  roll=node.get("roll").asText();
            String address=node.get("address").asText();
            boolean action=node.get("address").asBoolean();
            result=dashboardMapper.update(id,name,roll,address,action);
        }catch (Exception e){
            result=0;
        }
        return ResponseEntity.ok(mapper.createObjectNode().putPOJO("data",result));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        int result=0;
        try {
            result=dashboardMapper.delete(id);
        }catch (Exception e){
            result=0;
        }
        return ResponseEntity.ok(mapper.createObjectNode().putPOJO("data",result));
    }

}
