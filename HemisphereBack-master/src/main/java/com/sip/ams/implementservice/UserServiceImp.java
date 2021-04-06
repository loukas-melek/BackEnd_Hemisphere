package com.sip.ams.implementservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.User;
import com.sip.ams.repositories.UserRepository;
import com.sip.ams.services.UserService;





@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private  UserRepository userRepository;

	@Override
	public List<User> listerUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);
		
	}

	@Override
	public User updateUser(long id, User user) {
		User oldUser = userRepository.getById(id);
		if(oldUser!=null) {
			oldUser.setName(user.getName());
			oldUser.setLastName(user.getLastName());
			oldUser.setPassword(user.getPassword());
			oldUser.setEmail(user.getEmail());
			oldUser.setActive(user.getActive());
			oldUser.setImage(user.getImage());
			
			userRepository.save(oldUser);
		}
		return oldUser;
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User listUserById(long id) {
		
		return userRepository.getById(id);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public Long getUserRoleId(Long id) {
		
		return userRepository.getUserRoleId(id);
	}

    


}
