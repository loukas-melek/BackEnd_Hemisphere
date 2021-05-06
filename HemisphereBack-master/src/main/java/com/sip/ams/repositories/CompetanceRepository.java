package com.sip.ams.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.Competance;
import com.sip.ams.entities.Offer_Task_Solution;

@Repository("CompetanceRepository")
public interface CompetanceRepository extends JpaRepository<Competance, Long> {
	
	Competance findByCompetance(String Competance);
	
	@Query (value= "select * from offer_competance WHERE offer.id_user= :offer_id", nativeQuery= true )
	public List<Competance> getCompetanceByOfferId(@Param("offer_id") Long offer_id);

	@Query (value= "select * from offer_competance WHERE offer_competance.competance_id= :competance_id", nativeQuery= true )
	public List<Offer_Task_Solution> getOfferByCompetanceId(@Param("competance_id") Long competance_id);
	
	@Modifying
	@Transactional
	@Query(value="INSERT INTO offertask_competance (offertask_id,competance_id) VALUES (:offertask_id,:competance_id)",nativeQuery=true)
	void addCompetanceToOffertask(@Param("offertask_id") Long offertask_id, @Param("competance_id") Long competance_id);
	
	
	@Query(value="select competance_id from offertask_competance WHERE offertask_competance.offertask_id= :id ",nativeQuery=true)
	public List<Long> getListCompetance(@Param("id") Long id);
}
