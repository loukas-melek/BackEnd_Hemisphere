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
	
	@Query(value= "select * from Offer_Task_Solution ", nativeQuery= true )
	public List<Offer_Task_Solution> findAll();
	
	@Query (value= "select * from Offer_Task_Solution WHERE Offer_Task_Solution.id_user= :user_id", nativeQuery= true )
	public List<Offer_Task_Solution> getOfferByUserId(@Param("user_id") Long user_id);
	
	@Query (value= "select * from Offer_Task_Solution WHERE Offer_Task_Solution.categorie= :categorie", nativeQuery= true )
	public List<Offer_Task_Solution> getOfferByCategorie(@Param("categorie") String categorie);
	
	@Query (value= "select * from Offer_Task_Solution WHERE Offer_Task_Solution.type= :type", nativeQuery= true )
	public List<Offer_Task_Solution> getOfferByType(@Param("type") String type);
	
	@Query (value= "select * from Offer_Task_Solution WHERE Offer_Task_Solution.location= :location", nativeQuery= true )
	public List<Offer_Task_Solution> getOfferByLocation(@Param("location") String location);
	
	@Query(value="select *from Offer_Task_Solution WHERE Offer_Task_Solution.location=:location AND Offer_Task_Solution.type=:type AND Offer_Task_Solution.categorie=:categorie",nativeQuery=true)
	public List<Offer_Task_Solution> filter(@Param("location") String location,@Param("type") String type,@Param("categorie") String categorie);

	@Query(value="select *from Offer_Task_Solution WHERE Offer_Task_Solution.location=:location AND Offer_Task_Solution.type=:type ",nativeQuery=true)
	public List<Offer_Task_Solution> filterLocationType(@Param("location") String location,@Param("type") String type);
	
	@Query(value="select *from Offer_Task_Solution WHERE Offer_Task_Solution.location=:location AND Offer_Task_Solution.categorie=:categorie ",nativeQuery=true)
	public List<Offer_Task_Solution> filterLocationCategorie(@Param("location") String location,@Param("categorie") String categorie);
	
	@Query(value="select *from Offer_Task_Solution WHERE Offer_Task_Solution.type=:type AND Offer_Task_Solution.categorie=:categorie",nativeQuery=true)
	public List<Offer_Task_Solution> filterTypeCategorie(@Param("type") String type,@Param("categorie") String categorie);
	
	@Query(value="select *from Offer_Task_Solution WHERE Offer_Task_Solution.type=1",nativeQuery=true)
	public List<Offer_Task_Solution> listerTasks();
}
