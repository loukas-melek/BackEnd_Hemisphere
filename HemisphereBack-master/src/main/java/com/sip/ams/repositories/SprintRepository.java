package com.sip.ams.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sip.ams.entities.Sprint;
import com.sip.ams.entities.Sprint_Tasks;

@Repository("SprintRepository")
public interface SprintRepository extends JpaRepository<Sprint, Long>  {
	@Query (value= "select * from sprint WHERE sprint.id_project= :project_id", nativeQuery= true )
	public List<Sprint> getSprintsByproject(@Param("project_id") Long project_id);
}
