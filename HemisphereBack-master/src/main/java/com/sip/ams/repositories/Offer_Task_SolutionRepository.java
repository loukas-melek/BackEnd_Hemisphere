package com.sip.ams.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.Offer_Task_Solution;

@Repository("Offer_Task_SolutionRepository")
public interface Offer_Task_SolutionRepository extends JpaRepository<Offer_Task_Solution, Long>{

	@Query("select o from Offer_Task_Solution o where o.id=:id")
	public Offer_Task_Solution findOfferById(@Param("id")Long id);
	
	@Query(value= "select * from offer ORDER BY date DESC", nativeQuery= true )
	public List<Offer_Task_Solution> findAll();
	
	@Query (value= "select * from offer WHERE offer.id_user= :user_id", nativeQuery= true )
	public List<Offer_Task_Solution> getOfferByUserId(@Param("user_id") Long user_id);
	
	@Query (value= "select * from offer WHERE offer.categorie= :categorie", nativeQuery= true )
	public List<Offer_Task_Solution> getOfferByCategorie(@Param("categorie") String categorie);
	
	@Query (value= "select * from offer WHERE offer.type= :type", nativeQuery= true )
	public List<Offer_Task_Solution> getOfferByType(@Param("type") String type);
	
	@Query (value= "select * from offer WHERE offer.location= :location", nativeQuery= true )
	public List<Offer_Task_Solution> getOfferByLocation(@Param("location") String location);
	
	@Query(value="select *from offer WHERE offer.location=:location AND offer.type=:type AND offer.categorie=:categorie",nativeQuery=true)
	public List<Offer_Task_Solution> filter(@Param("location") String location,@Param("type") String type,@Param("categorie") String categorie);

	@Query(value="select *from offer WHERE offer.location=:location AND offer.type=:type ",nativeQuery=true)
	public List<Offer_Task_Solution> filterLocationType(@Param("location") String location,@Param("type") String type);
	
	@Query(value="select *from offer WHERE offer.location=:location AND offer.categorie=:categorie ",nativeQuery=true)
	public List<Offer_Task_Solution> filterLocationCategorie(@Param("location") String location,@Param("categorie") String categorie);
	
	@Query(value="select *from offer WHERE offer.type=:type AND offer.categorie=:categorie",nativeQuery=true)
	public List<Offer_Task_Solution> filterTypeCategorie(@Param("type") String type,@Param("categorie") String categorie);
	
	@Query(value="select *from offer WHERE offer.type='TASK'",nativeQuery=true)
	public List<Offer_Task_Solution> listerTasks();
}
