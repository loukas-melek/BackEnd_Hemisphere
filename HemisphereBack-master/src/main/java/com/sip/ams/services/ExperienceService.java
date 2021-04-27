package com.sip.ams.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sip.ams.entities.Experience;
import com.sip.ams.entities.General_Post;
@Service
public interface ExperienceService {
	List<Experience> listerExperiences();
	void addPub(Experience experience);
	Experience updateExperience(Long id,Experience experience);
	void deleteExperience(Long id);
	List<Experience> getExperienceByUserId(Long user_id);
}
