package com.sip.ams.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.dto.UserDataDTO;
import com.sip.ams.dto.UserResponseDTO;
import com.sip.ams.entities.Profile;
import com.sip.ams.entities.Role;
import com.sip.ams.entities.User;
import com.sip.ams.payload.request.LoginRequest;
import com.sip.ams.payload.request.RegisterRequest;
import com.sip.ams.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;


@RestController
@RequestMapping("/users")
@CrossOrigin("*")
@Api(tags = "users")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping("/signin")
  @ApiOperation(value = "${UserController.signin}")
  @ApiResponses(value = {//
		  @ApiResponse(code = 400, message = "Something went wrong"), //	  
		  @ApiResponse(code = 422, message = "Invalid username/password supplied")})	 
  public String login(//
		  @Valid @RequestBody LoginRequest loginRequest) {
	  System.out.println("nchoufou el token kifeh");
	  System.out.println(userService.signin(loginRequest.getUsername(),loginRequest.getPassword()));
    return userService.signin(loginRequest.getUsername(),loginRequest.getPassword());
  }

  @PostMapping("/signup")
  @ApiOperation(value = "${UserController.signup}")
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 422, message = "Username is already in use")})
  public String signup(@ApiParam("Signup User") @RequestBody RegisterRequest user) {
	  System.out.println(user.getUsername());
	  System.out.println(user.getRoles());
	  User u = new User();
	  Profile p = new Profile();
	  u.setEmail(user.getEmail());
	  u.setPassword(user.getPassword());
	  u.setUsername(user.getUsername());
	  Integer r =user.getRoles();
	  if(r==1) {
		  System.out.println("dkhalna lel if aal role student");
		  List<Role> role = new ArrayList();
		  role.add(Role.ROLE_STUDENT);
		  u.setRoles(role);
		  System.out.println(role);
	  }
	  if(r==3) {
		  System.out.println("dkhalna lel if aal role company");
		  List<Role> role =  new ArrayList();
		  role.add(Role.ROLE_COMPANY);
		  u.setRoles(role);
		  System.out.println(role);
	  }
	  p.setName(user.getName());
	  p.setLastname(user.getLastname());
	  p.setPhone(user.getPhone());
	  p.setCity(user.getCity());
	  p.setLocation(user.getLocation());
	  p.setGender(user.isGender());
    return userService.signup(u,p);
	  //return userService.signup(user);
  }

  @DeleteMapping(value = "/{username}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @ApiOperation(value = "${UserController.delete}", authorizations = { @Authorization(value="apiKey") })
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 404, message = "The user doesn't exist"), //
      @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
  public String delete(@ApiParam("Username") @PathVariable String username) {
    userService.delete(username);
    return username;
  }

  @GetMapping(value = "/{username}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @ApiOperation(value = "${UserController.search}", response = UserResponseDTO.class, authorizations = { @Authorization(value="apiKey") })
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 404, message = "The user doesn't exist"), //
      @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
  public UserResponseDTO search(@ApiParam("Username") @PathVariable String username) {
    return modelMapper.map(userService.search(username), UserResponseDTO.class);
  }

  @GetMapping(value = "/me")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_STUDENT') or hasRole('ROLE_COMPANY')")
  @ApiOperation(value = "${UserController.me}", response = UserResponseDTO.class, authorizations = { @Authorization(value="apiKey") })
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
  public UserResponseDTO whoami(HttpServletRequest req) {
    return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
  }

  @GetMapping("/refresh")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
  public String refresh(HttpServletRequest req) {
    return userService.refresh(req.getRemoteUser());
  }

  @PostMapping("/check/{userId}")
  public boolean checkPass(@PathVariable Integer userId, @Valid
			@RequestBody String password) {
	  System.out.println(userId);
	  System.out.println(password);
    return userService.checkPassword(password, userId);
  }
  
  @PutMapping("update/{userId}")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_STUDENT') or hasRole('ROLE_COMPANY')")
	 public User updateUser(@PathVariable Integer userId, @Valid
	@RequestBody User user) {
	  
		 return userService.updateUser(userId, user);
			 }
  
}
