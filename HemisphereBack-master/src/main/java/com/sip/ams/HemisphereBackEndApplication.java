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
import com.sip.ams.payload.request.RegisterRequest;
import com.sip.ams.services.UserService;
import com.sip.ams.entities.Profile;
import com.sip.ams.entities.Role;


@SpringBootApplication
public class HemisphereBackEndApplication implements CommandLineRunner {
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
		 * Profile adminp= new Profile(); User admin = new User();
		 * admin.setUsername("admin"); admin.setPassword("admin");
		 * admin.setEmail("admin@email.com"); adminp.setName("malek");
		 * adminp.setLastname("ben yedder"); adminp.setPhone("56240881");
		 * adminp.setCity("Rades"); adminp.setLocation("Tunisia");
		 * adminp.setGender(false); admin.setRoles(new
		 * ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));
		 * 
		 * userService.signup(admin,adminp);
		 * 
		 * Profile sProfile = new Profile(); User sUser = new User();
		 * sUser.setUsername("student"); sUser.setPassword("suser");
		 * sUser.setEmail("student@email.com");
		 * 
		 * sUser.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_STUDENT)));
		 * sProfile.setName("Firas"); sProfile.setLastname("Ben Hamida");
		 * sProfile.setPhone("54530644"); sProfile.setCity("Rades");
		 * sProfile.setLocation("Tunisia"); sProfile.setGender(false);
		 * 
		 * userService.signup(sUser,sProfile); Profile pprofile=new Profile(); User
		 * pUser = new User(); pUser.setUsername("puser"); pUser.setPassword("puser");
		 * pUser.setEmail("puser@email.com");
		 * 
		 * pUser.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_COMPANY)));
		 * pprofile.setName("Ahmed"); pprofile.setLastname("Dridi");
		 * pprofile.setPhone("90050177"); pprofile.setCity("Madina");
		 * pprofile.setLocation("Tunisia"); pprofile.setGender(false);
		 * userService.signup(pUser,pprofile);
		 */
		 
		 
		 
		 
		
	}

}
