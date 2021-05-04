package com.sip.ams.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sip.ams.dto.ProjectDto;
import com.sip.ams.entities.Project;

@Repository("ProjectRepository")
public interface ProjectRepository extends JpaRepository<Project, Long> {
	@Modifying
	@Transactional
	@Query(value="INSERT INTO student_project (proj_id,students_id) VALUES (:proj_id,:students_id)",nativeQuery=true)
	void ConfirmProject(@Param("proj_id") Long proj_id, @Param("students_id") Long students_id);
	
	@Query(value="Select * from project where project.id_generale_post=:id",nativeQuery=true)
	Project findByGeneralPostId(@Param("id") Long id );
	
	@Query(value="Select proj_id  from student_project where student_project.students_id=:id",nativeQuery=true)
	List<Long> FindByStudent(@Param("id") Long id );
	
	@Query(value="Select *  from project where project.profile_id=:id",nativeQuery=true)
	List<Project> FindByCompany(@Param("id") Long id );
}
