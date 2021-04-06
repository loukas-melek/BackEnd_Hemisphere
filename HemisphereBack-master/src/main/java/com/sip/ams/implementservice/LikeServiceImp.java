package com.sip.ams.implementservice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Like;
import com.sip.ams.repositories.LikeRepository;
import com.sip.ams.services.LikeService;
@Service
public class LikeServiceImp implements LikeService {
	@Autowired
	private LikeRepository likeRepository;
	@Override
	public List<Like> listerLikes() {
		// TODO Auto-generated method stub
		return likeRepository.findAll();
	}

	@Override
	public Like addComment(Like like) {
		// TODO Auto-generated method stub
		Like l= likeRepository.save(like);
		 
		 return l;
	}

	@Override
	public Like updateLike(Long id, Like like) {
		// TODO Auto-generated method stub
		Like l = likeRepository.getOne(id);
		if(l!=null) {
			l.setProfile(like.getProfile());
			l.setCreated_at(like.getCreated_at());
			l.setUpdated_at(like.getUpdated_at());
			l.setGeneralpost(like.getGeneralpost());
			likeRepository.save(l);
		}
		return l;
	}

	@Override
	public void deleteLike(Long id) {
		// TODO Auto-generated method stub
		likeRepository.deleteById(id);
	}

	@Override
	public Like findLikeById(Long id) {
		// TODO Auto-generated method stub
		return likeRepository.findLikeById(id);
	}

	@Override
	public Long findByUserPub(Long iduser, Long idpub) {
		// TODO Auto-generated method stub
Like l =	 likeRepository.findByUserPub(iduser, idpub);
if (l!=null) {
	return l.getId();
}
	return 0L;	
	}

	@Override
	public int nlikes(Long idpub) {
		// TODO Auto-generated method stub
		return likeRepository.nlikes(idpub);
	}

}
