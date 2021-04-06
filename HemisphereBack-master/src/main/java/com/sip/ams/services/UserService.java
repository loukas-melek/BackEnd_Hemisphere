package com.sip.ams.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sip.ams.entities.User;
@Service
public interface UserService {
	List<User> listerUser();
	void addUser(User user);
	User updateUser(long id,User user);
	void deleteUser(long id);
	User listUserById(long id);
	User findByEmail(String email);
	Long getUserRoleId(Long id);
}
