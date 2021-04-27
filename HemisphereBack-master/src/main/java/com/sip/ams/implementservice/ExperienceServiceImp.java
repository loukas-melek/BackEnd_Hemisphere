package com.sip.ams.implementservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Experience;
import com.sip.ams.repositories.CompetanceRepository;
import com.sip.ams.repositories.ExperienceRepository;
import com.sip.ams.services.ExperienceService;
@Service
public class ExperienceServiceImp  implements ExperienceService{
	@Autowired
	private ExperienceRepository experienceRepository;
	@Override
	public List<Experience> listerExperiences() {
		// TODO Auto-generated method stub
		return experienceRepository.findAll();
	}

	@Override
	public void addPub(Experience experience) {
		// TODO Auto-generated method stub
		experienceRepository.save(experience);
	}

	@Override
	public Experience updateExperience(Long id, Experience experience) {
		Experience e = experienceRepository.getOne(id);
		if(e!=null) {
			e.setCompany(experience.getCompany());
			e.setCreated_at(experience.getCreated_at());
			e.setUpdated_at(experience.getUpdated_at());
			e.setDescription(experience.getDescription());
			e.setProfile(experience.getProfile());
			e.setType(experience.getType());
			e.setTitle(experience.getTitle());
		}
		return experienceRepository.save(e);
	}

	@Override
	public void deleteExperience(Long id) {
		// TODO Auto-generated method stub
		experienceRepository.deleteById(id);
	}


	@Override
	public List<Experience> getExperienceByUserId(Long user_id) {
		// TODO Auto-generated method stub
		return experienceRepository.getExperienceByUserId(user_id);
	}

}
