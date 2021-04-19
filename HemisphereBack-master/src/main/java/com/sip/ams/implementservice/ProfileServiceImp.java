package com.sip.ams.implementservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Profile;
import com.sip.ams.repositories.General_PostRepository;
import com.sip.ams.repositories.ProfileRepository;
import com.sip.ams.services.ProfileService;
@Service
public class ProfileServiceImp implements ProfileService {
	@Autowired
	private ProfileRepository profileRepository;
	@Override
	public Profile findByUserId(Integer id) {
		// TODO Auto-generated method stub
		return profileRepository.findByUserId(id);
	}

}
