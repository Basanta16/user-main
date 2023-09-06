package com.basanta.usercrud.controller;


import com.basanta.usercrud.pojo.UserPojo;
import com.basanta.usercrud.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


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
    
    
    @PostMapping("/update")
    public ResponseEntity<String> updateUser (@RequestBody UserPojo userPojo){
    	
    	String updatedUser = userService.updateUser(userPojo);
    	
    	return ResponseEntity.ok("Updated Successfully..." + updatedUser);
    }
}
