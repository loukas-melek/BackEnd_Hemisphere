package com.sip.ams.services;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Like;
@Service
public interface LikeService {
	Like findLikeById( Long id);

	List<Like> listerLikes();
	Like addComment(Like like);
	Like updateLike(Long id,Like like);
	void deleteLike(Long id);
	Long findByUserPub(Long iduser,Long idpub );
	int nlikes ( Long idpub );

	//List<Like> listerLikeByPub(Long id);
}
