package com.sip.ams.services;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Post;
import com.sip.ams.entities.Profile;
@Service
public interface ProfileService {
	Profile findByUserId( Integer id ) throws FileNotFoundException;
	List<Profile> listerProfiles();
	void addProfile(Profile profile);
	Profile updateProfile(Long id,Profile profile);
	void deleteProfile(Long id);
}
