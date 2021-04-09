package com.sip.ams.implementservice;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.General_Post;
import com.sip.ams.entities.Profile;
import com.sip.ams.entities.SharedPost;
import com.sip.ams.repositories.General_PostRepository;
import com.sip.ams.repositories.ProfileRepository;
import com.sip.ams.repositories.SharedPostRepository;

import com.sip.ams.services.SharedPostService;
@Service
public class SharedPostServiceImp implements SharedPostService {
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private SharedPostRepository sharedPostRepository;
	@Autowired
	private General_PostRepository general_PostRepository;
	@Override
	public List<SharedPost> listerSharedPost() {
		// TODO Auto-generated method stub
		return sharedPostRepository.findAll();
	}

	@Override
	public void addSharedPost(SharedPost sharedPost,Long id) {
		// TODO Auto-generated method stub
		sharedPostRepository.save(sharedPost);
		 General_Post p= new General_Post(); 
		 Date d = new Date(System.currentTimeMillis());
		 p.setCreated_at(d);
		 p.setUpdated_at(d);
		 p.setSharedpost(sharedPost);
		 System.out.println(id);
		 System.out.println(p.getUpdated_at());
		 Profile u =profileRepository.getOne(id);
		
		 System.out.println(u);
		 System.out.println(p.getSharedpost());
		 p.setProfile(u);

		 System.out.println(p.getUpdated_at());
		 System.out.println(p.getSharedpost());
		general_PostRepository.save(p);
	}

	@Override
	public SharedPost updateSharedPost(Long id, SharedPost react) {
		// TODO Auto-generated method stub
		SharedPost oldpost = sharedPostRepository.getOne(id);
		if(oldpost!=null) {
			oldpost.setPub(react.getPub());
			sharedPostRepository.save(oldpost);
		}
		return oldpost ;
	}

	@Override
	public void deleteSharedPost(Long id) {
		// TODO Auto-generated method stub
		sharedPostRepository.deleteById(id);
	}

	@Override
	public int nshare(Long idpub) {
		// TODO Auto-generated method stub
		return sharedPostRepository.nShares(idpub);
	}

}
