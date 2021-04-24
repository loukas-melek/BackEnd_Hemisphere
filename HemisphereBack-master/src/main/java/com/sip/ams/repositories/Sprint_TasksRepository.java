package com.sip.ams.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.Sprint_Tasks;

@Repository("Sprint_TasksRepository")
public interface Sprint_TasksRepository extends JpaRepository<Sprint_Tasks, Long> {
	
	@Query (value= "select * from sprint_tasks WHERE sprint_tasks.id_sprint= :sprint_id", nativeQuery= true )
	public List<Sprint_Tasks> getTasksbySprint(@Param("sprint_id") Long sprint_id);
}
