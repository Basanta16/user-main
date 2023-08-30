package com.basanta.usercrud.controller;


import com.basanta.usercrud.entity.User;
import com.basanta.usercrud.pojo.UserPojo;
import com.basanta.usercrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public ResponseEntity<String> create (@RequestBody UserPojo userPojo){

        userService.createUser(userPojo);
        return ResponseEntity.ok("Created SuccessFully...");
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<String> viewuser (@PathVariable("id") Long id){

        String viewUser = userService.viewUser(id);

        return ResponseEntity.ok("Data Fetched...."+ viewUser);
    }
    
    
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser (@PathVariable("id") Long id){
    	
    	userService.deleteUser(id);
    	return ResponseEntity.ok("Deleted Succesfully...");
    }
    
    
    @PostMapping("/update/{id}")
    public ResponseEntity<String> updateUser (@PathVariable("id") Long id, @RequestBody UserPojo userPojo){
    	
    	
    	return ResponseEntity.ok("Updated Successfully...");
    }
}
