package com.sip.ams.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.sip.ams.entities.Experience;

@Repository("ExperienceRepository")
public interface ExperienceRepository  extends JpaRepository<Experience, Long> {
	@Query (value= "select * from experience WHERE experience.id_profile= :user_id ", nativeQuery= true )
	public List<Experience> getExperienceByUserId(@Param("user_id") Long user_id);
}
