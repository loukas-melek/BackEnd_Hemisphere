package com.sip.ams.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sip.ams.entities.SharedPost;

@Service
public interface SharedPostService {
	List<SharedPost> listerSharedPost();
	void addSharedPost(SharedPost react,Long id);
	SharedPost updateSharedPost(Long id,SharedPost react);
	void deleteSharedPost(Long id);
	int nshare(Long idpub);
}
