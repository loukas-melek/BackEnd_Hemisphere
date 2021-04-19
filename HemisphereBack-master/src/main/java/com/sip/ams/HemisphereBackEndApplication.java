package com.sip.ams;

import java.util.ArrayList;
import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sip.ams.entities.User;
import com.sip.ams.services.UserService;
import com.sip.ams.entities.Role;


@SpringBootApplication
public class HemisphereBackEndApplication implements CommandLineRunner{
	@Autowired
	  UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(HemisphereBackEndApplication.class, args);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}
	 @Bean
	  public ModelMapper modelMapper() {
	    return new ModelMapper();
	  }
	@Override
	public void run(String... args) throws Exception {
		/*
		 * User admin = new User(); admin.setUsername("admin");
		 * admin.setPassword("admin"); admin.setEmail("admin@email.com");
		 */
	    //admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));
		/*
		 * userService.signup(admin,"admin");
		 * 
		 * User sUser = new User(); sUser.setUsername("suser");
		 * sUser.setPassword("suser"); sUser.setEmail("suser@email.com");
		 */
	    //sUser.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_STUDENT)));

		/*
		 * userService.signup(sUser,"student");
		 * 
		 * User pUser = new User(); pUser.setUsername("puser");
		 * pUser.setPassword("puser"); pUser.setEmail("puser@email.com");
		 */
	    //pUser.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_COMPANY)));

		/* userService.signup(pUser,"company"); */
		
	}

}
