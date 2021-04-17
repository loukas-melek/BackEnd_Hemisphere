package com.sip.ams.services;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Role;
import com.sip.ams.entities.User;
import com.sip.ams.exception.CustomException;
import com.sip.ams.repositories.UserRepository;
import com.sip.ams.security.JwtTokenProvider;



@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;

  @Autowired
  private AuthenticationManager authenticationManager;

  public String signin(String username, String password) {
	  System.out.println("we are in the login service please work");
	  System.out.println(username);
	  System.out.println(password);
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
      return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
    } catch (AuthenticationException e) {
      throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  public String signup(User user,String role) {
    if (!userRepository.existsByUsername(user.getUsername())) {
    	System.out.println(role);
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      if(role.equals("student")) {
      user.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_STUDENT)));
      }else if(role.equals("company")) {
    	  user.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_COMPANY)));
      }else if (role.equals("admin")) {
    	  user.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));
      }
      System.out.println(user.getRoles());
      System.out.println(user.getUsername());
      userRepository.save(user);
      return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
    } else {
      throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  public void delete(String username) {
    userRepository.deleteByUsername(username);
  }

  public User search(String username) {
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
    }
    return user;
  }

  public User whoami(HttpServletRequest req) {
    return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
  }

  public String refresh(String username) {
    return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
  }

}
