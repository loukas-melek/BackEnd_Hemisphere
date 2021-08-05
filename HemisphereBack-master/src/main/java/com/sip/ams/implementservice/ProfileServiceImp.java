package com.sip.ams.implementservice;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.util.Base64Decoder;
import com.sip.ams.entities.Profile;
import com.sip.ams.repositories.General_PostRepository;
import com.sip.ams.repositories.ProfileRepository;
import com.sip.ams.services.ProfileService;
@Service
public class ProfileServiceImp implements ProfileService {
	@Autowired
	private ProfileRepository profileRepository;
	@Override
	public Profile findByUserId(Integer id)  {
		// TODO Auto-generated method stub
		Profile p= profileRepository.findByUserId(id);
		/*
		 * if(p.getProfilePicUrl()!=null) { System.out.println(p.getEmail());
		 * System.out.println(p.getProfilePicUrl()); File file = new
		 * File(p.getProfilePicUrl()); Scanner sc = new Scanner(file); String
		 * fileContent =""; while(sc.hasNextLine()) { fileContent=sc.nextLine();
		 * p.setProfilePicUrl(fileContent);
		 * System.out.println("content : "+fileContent); } }
		 * System.out.println(p.getProfilePicUrl());
		 */
		return p;
	}
	
	public String ConvertToImage(String text,String dataDir,String fileName) throws IOException {
		String base64ImageString = text.replace("data:image/png;base64,", "");
		System.out.println("Converting ....");
		System.out.println(text);
		System.out.println(base64ImageString);
		byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64ImageString);
		String path = dataDir +fileName+".jpg";
		FileOutputStream fos = new FileOutputStream(path);
		
		try {
		    fos.write(imageBytes);
		}
		finally {
		    fos.close();
		}

		System.out.println("Convertion Done..");
		System.out.println("Location : "+path);
		return path;
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
		String dirName = "/home/ubuntu/images/";

		String  test = "C:\\Users\\loukas\\Desktop\\hemisphere\\front-master\\front-master\\src\\assets\\images\\";
		File file = new File(dirName+profile.getEmail()+".txt");
		try {
		if(!file.exists()) {
				file.createNewFile();
			}
		//p.setProfilePicUrl(file.getAbsolutePath());
		PrintWriter pw = new PrintWriter(file);
		pw.println(profile.getProfilePicUrl());
		pw.close();
		System.out.println("Succss done!");
		String path = ConvertToImage(profile.getProfilePicUrl(),dirName,profile.getEmail());
		System.out.println("original path : --"+path);
		p.setProfilePicUrl(path.substring(65));
		p.setProfileTextUrl(path.substring(65).replace(".jpg", ".txt"));
		System.out.println("adjuted path ** "+p.getProfilePicUrl());
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
