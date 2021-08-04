package com.sip.ams.converts;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.sip.ams.dto.ProfileDto;
import com.sip.ams.dto.ProjectDto;
import com.sip.ams.dto.SprintDto;
import com.sip.ams.dto.TasksDto;
import com.sip.ams.entities.Profile;
import com.sip.ams.entities.Project;
import com.sip.ams.entities.Sprint;
import com.sip.ams.entities.Sprint_Tasks;

public class ProfileConverter {
	
	
	public Profile convertDtpToProfile(ProfileDto profile) {
//		ModelMapper mapper = new ModelMapper();
//		SprintDto map = mapper.map(sprint, SprintDto.class);
//		return map;
		Profile dto = new Profile();
		dto.setAbout(profile.getAbout());
		dto.setCity(profile.getCity());
		dto.setEmail(profile.getEmail());
		dto.setGender(profile.isGender());
		dto.setId(profile.getId());
		//dto.setImagepath(profile.getImagepath());
		dto.setInterests(profile.getInterests());
		dto.setLanguages(profile.getLanguages());
		dto.setLastname(profile.getLastname());
		dto.setLocation(profile.getLocation());
		dto.setName(profile.getName());
		dto.setPhone(profile.getPhone());
		dto.setState(profile.getState());
		dto.setUser(profile.getUser());
		return dto;
	}
	
	
}
