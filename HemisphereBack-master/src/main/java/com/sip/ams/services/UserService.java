package com.sip.ams.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Profile;
import com.sip.ams.entities.Role;
import com.sip.ams.entities.User;
import com.sip.ams.exception.CustomException;
import com.sip.ams.repositories.ProfileRepository;
import com.sip.ams.repositories.UserRepository;
import com.sip.ams.security.JwtTokenProvider;



@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private ProfileRepository profileRepository;
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

  public String signup(User user,Profile profile) {
    if (!userRepository.existsByUsername(user.getUsername())) {
    	 User u = new User();
    	u.setEmail(user.getEmail());
    	u.setRoles(user.getRoles());
    	u.setUsername(user.getUsername());
      u.setPassword(passwordEncoder.encode(user.getPassword()));
      System.out.println(user.getRoles());
      System.out.println(user.getUsername());
      userRepository.save(u);
      profile.setCreated_at(new Date());
      profile.setUpdated_at(new Date());
      profile.setUser(u);
      profile.setEmail(user.getEmail());
      profileRepository.save(profile);
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
  public User updateUser(Integer id,User user) {
	  User u = userRepository.getOne(id);
	  if(u!=null) {
	  u.setEmail(user.getEmail());
	  u.setPassword(passwordEncoder.encode(user.getPassword()));
	  u.setUsername(user.getUsername());
	  }
	return userRepository.save(u);
	  
  }
  
  public boolean checkPassword(String password,Integer id) {
	 
	  User u=userRepository.getOne(id);
	  System.out.println(u.getPassword());
	  System.out.println(password);
	  password.toString();
	  boolean isPasswordMatch = passwordEncoder.matches(password, u.getPassword());
	  System.out.println(isPasswordMatch);
	  return isPasswordMatch;
  
  }
}
