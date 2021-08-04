package com.sip.ams.implementservice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
	public Profile findByUserId(Integer id) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Profile p= profileRepository.findByUserId(id);
		if(p.getProfilePicUrl()!=null) {
		System.out.println(p.getEmail());
		System.out.println(p.getProfilePicUrl());
		File file = new File(p.getProfilePicUrl());
		Scanner sc = new Scanner(file);
		String fileContent ="";
		while(sc.hasNextLine()) {
			fileContent=sc.nextLine();
			p.setProfilePicUrl(fileContent);
			System.out.println("content : "+fileContent);
		}
		}
		System.out.println(p.getProfilePicUrl());
		return p;
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
	public Profile updateProfile(Long id, Profile profile)  {
		Profile p = profileRepository.getOne(id);
		if(p!=null) {
		p.setAbout(profile.getAbout());
		p.setGender(profile.isGender());
		p.setInterests(profile.getInterests());
		p.setLanguages(profile.getLanguages());
		p.setLocation(profile.getLocation());
		//p.setProfilePicUrl(profile.getProfilePicUrl());
		p.setUpdated_at(new Date());
		p.setCity(profile.getCity());
		p.setPhone(profile.getPhone());
		p.setName(profile.getName());
		p.setLastname(profile.getLastname());
		p.setState(profile.getState());
		String dirName = "/home/ubuntu/Deploy Here/images/";

		String  test = "C:\\Users\\loukas\\Desktop\\hemisphere\\";
		File file = new File(dirName+profile.getEmail()+".txt");
		try {
		if(!file.exists()) {
			String path ="";
				file.createNewFile();
			}
		p.setProfilePicUrl(file.getAbsolutePath());
		PrintWriter pw = new PrintWriter(file);
		pw.println(profile.getProfilePicUrl());
		pw.close();
		System.out.println("Succss done!");
		System.out.println(p.getProfilePicUrl());
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
