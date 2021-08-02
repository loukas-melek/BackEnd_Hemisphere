package com.sip.ams.implementservice;

import java.util.Date;
import java.util.List;

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
	@Override
	public List<Profile> listerProfiles() {
		// TODO Auto-generated method stub
		return profileRepository.findAll();
	}
	@Override
	public void addProfile(Profile profile) {
		// TODO Auto-generated method stub
		profileRepository.save(profile);
	}
	@Override
	public Profile updateProfile(Long id, Profile profile) {
		Profile p = profileRepository.getOne(id);
		if(p!=null) {
		p.setAbout(profile.getAbout());
		p.setGender(profile.isGender());
		p.setInterests(profile.getInterests());
		p.setLanguages(profile.getLanguages());
		p.setLocation(profile.getLocation());
		p.setProfilePicUrl(profile.getProfilePicUrl());
		p.setUpdated_at(new Date());
		p.setCity(profile.getCity());
		p.setPhone(profile.getPhone());
		p.setName(profile.getName());
		p.setLastname(profile.getLastname());
		p.setState(profile.getState());
		}
		profileRepository.save(p);
		return p;
	}
	@Override
	public void deleteProfile(Long id) {
		// TODO Auto-generated method stub
		profileRepository.deleteById(id);
	}

}
