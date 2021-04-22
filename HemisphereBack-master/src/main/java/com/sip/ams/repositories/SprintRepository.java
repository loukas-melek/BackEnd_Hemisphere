package com.sip.ams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sip.ams.entities.Sprint;

@Repository("SprintRepository")
public interface SprintRepository extends JpaRepository<Sprint, Long>  {
	
}
