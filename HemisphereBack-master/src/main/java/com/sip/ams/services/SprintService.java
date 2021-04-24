package com.sip.ams.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


import com.sip.ams.entities.Sprint;

	@Service
	public interface SprintService  {
		List<Sprint> getAllSprints();
		Sprint getSprintById(long sprint_id);
		Sprint insert(Sprint sprint);
		void saveOrUpdate(Sprint sprint,long sprint_id);
		void delete(long sprint_id);
		public List<Sprint> getSprintsByproject(Long project_id);
}
