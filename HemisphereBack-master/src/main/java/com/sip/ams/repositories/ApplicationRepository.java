package com.sip.ams.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.Application;



@Repository("ApplicationRepository")
public interface ApplicationRepository extends JpaRepository<Application, Long>{


	@Query("select d from Application d where d.id=:id")
	public Application findDemandeById(@Param("id")Long id);
	
	@Query (value= "select * from Application WHERE Application.id_profile= :user_id", nativeQuery= true )
	public List<Application> getDemandeByUserId(@Param("user_id") Long user_id);
	
	@Query (value= "select * from Application WHERE Application.offer_task_solution_id= :offer_id", nativeQuery= true )
	public List<Application> getDemandeByOfferId(@Param("offer_id") Long offer_id);
	
	

}
