package com.sip.ams.services;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sip.ams.dto.SprintDto;
import com.sip.ams.entities.Sprint;

	@Service
	public interface SprintService  {
		List<Sprint> getAllSprints();
		SprintDto getSprintById(Long sprint_id);
		Sprint insert(Sprint sprint);
		void saveOrUpdate(Sprint sprint,Long sprint_id);
		void delete(Long sprint_id);
		public List<SprintDto> getSprintsByproject(Long project_id);
}
