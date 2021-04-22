package com.sip.ams.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;
import com.sip.ams.entities.Profile;
import com.sip.ams.entities.Project;

@Repository("ProjectRepository")
public interface ProjectRepository extends JpaRepository<Project, Long> {
	
}
