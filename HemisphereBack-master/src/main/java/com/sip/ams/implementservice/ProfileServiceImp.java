package com.sip.ams.implementservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	public String writeToFile(String imageUrl, String Filename)  {
	    
		 String path= new String();
		    BufferedWriter writer;
			try {
				writer = new BufferedWriter(new FileWriter(Filename));
				   writer.write(imageUrl);
			        File f = new File(Filename);
			       path= f.getAbsoluteFile().toString();
				    writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return path;
	}
	
	@Override
	public Profile updateProfile(Long id, Profile profile)  {
		Profile p = profileRepository.getOne(id);
		if(p!=null) {
		p.setAbout(profile.getAbout());
		p.setGender(profile.isGender());
		p.setInterests(profile.getInterests());
		p.setLanguages(profile.getLanguages());
		p.setLocation(profile.getLocation());
		//p.setProfilePicUrl(profile.getProfilePicUrl());
		p.setProfilePicUrl(writeToFile(profile.getProfilePicUrl(), profile.getEmail()));
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
