package com.sip.ams.implementservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.General_Post;
import com.sip.ams.repositories.ApplicationRepository;
import com.sip.ams.repositories.General_PostRepository;
import com.sip.ams.services.General_PostService;
@Service

public class General_PostServiceImp implements General_PostService {
	@Autowired
	private General_PostRepository general_PostRepository;

	@Override
	public List<General_Post> listerPubs() {
		// TODO Auto-generated method stub
		return general_PostRepository.findAll();
	}

	@Override
	public void addPub(General_Post offer) {
		// TODO Auto-generated method stub
		general_PostRepository.save(offer);
	}

	@Override
	public General_Post updatePub(Long id, General_Post offer) {
		// TODO Auto-generated method stub
		General_Post updatedPub=general_PostRepository.findPubById(id);
		if(updatedPub!=null) {
			updatedPub.setOffer(offer.getOffer());
			updatedPub.setNlike(offer.getNlike());
			updatedPub.setPost(offer.getPost());
			updatedPub.setAffichedate(offer.getAffichedate());
			updatedPub.setComment(offer.getComment());
			updatedPub.setCreated_at(offer.getCreated_at());
			updatedPub.setUpdated_at(offer.getUpdated_at());
			updatedPub.setProfile(offer.getProfile());
			updatedPub.setSharedpost(offer.getSharedpost());
			general_PostRepository.save(updatedPub);
		}
		return updatedPub;
	}

	@Override
	public void deletePub(Long id) {
		// TODO Auto-generated method stub
		general_PostRepository.deleteById(id);
	}

	@Override
	public General_Post listPubById(Long id) {
		// TODO Auto-generated method stub
		return general_PostRepository.findPubById(id);
	}

	@Override
	public List<General_Post> getPubByUserId(Long user_id) {
		// TODO Auto-generated method stub
		return general_PostRepository.getPubByUserId(user_id);
	}

	@Override
	public List<General_Post> listerAll() {
		// TODO Auto-generated method stub
		return general_PostRepository.listerAll();
	}
	
	
}
