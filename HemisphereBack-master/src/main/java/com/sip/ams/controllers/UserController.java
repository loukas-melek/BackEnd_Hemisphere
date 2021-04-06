package com.sip.ams.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.User;
import com.sip.ams.services.UserService;


@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public List<User> findAll(){
        return userService.listerUser();
    }
    
    @GetMapping("/byEmail/{email}")
    public User findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }
    
    @GetMapping("/byId/{id}")
    public User findByid(@PathVariable Long id){
        return userService.listUserById(id);
    }
    @GetMapping("/role/{id}")
    public Long findRoleByUserId(@PathVariable Long id){
        return userService.getUserRoleId(id);
    }
    @PostMapping("/add")
    public void save(@RequestBody User user){
        userService.addUser(user);
    }

    @PutMapping("/update/{userId}")
    public User update(@PathVariable long userId, @Valid
    		@RequestBody User userRequest){
       return userService.updateUser(userId, userRequest);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.deleteUser(id);
        
    }


}
