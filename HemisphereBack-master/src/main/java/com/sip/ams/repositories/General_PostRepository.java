package com.sip.ams.repositories;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.General_Post;



@Repository("General_PostRepository")
public interface General_PostRepository extends JpaRepository<General_Post, Long>{

	@Query(value= "select * from General_Post WHERE General_Post.id= :id AND General_Post.archived=false", nativeQuery= true)
	public General_Post findPubById(@Param("id")Long id);
	 
	
	@Query (value= "select * from General_Post WHERE General_Post.id_profile= :user_id AND General_Post.archived=false", nativeQuery= true )
	public List<General_Post> getPubByUserId(@Param("user_id") Long user_id);
	
	@Query (value= "select * from General_Post WHERE General_Post.id_user= :user_id AND General_Post.archived=false", nativeQuery= true )
	public List<General_Post> getPubByReact(@Param("user_id") Long user_id);
	
	 @Query(value="select * from General_Post where General_Post.archived=false",nativeQuery=true) 
	 public List<General_Post> listerAll();
	
	 
	 
	/*
	 * @Query (value= "select * from pub WHERE pub.categorie= :categorie",
	 * nativeQuery= true ) public List<General_Post> getOfferByCategorie(@Param("categorie")
	 * String categorie);
	 * 
	 * @Query (value= "select * from pub WHERE pub.type= :type", nativeQuery= true )
	 * public List<General_Post> getOfferByType(@Param("type") String type);
	 * 
	 * @Query (value= "select * from pub WHERE pub.location= :location",
	 * nativeQuery= true ) public List<General_Post> getOfferByLocation(@Param("location")
	 * String location);
	 * 
	 * @Query(
	 * value="select *from pub WHERE pub.location=:location AND pub.type=:type AND pub.categorie=:categorie"
	 * ,nativeQuery=true) public List<General_Post> filter(@Param("location") String
	 * location,@Param("type") String type,@Param("categorie") String categorie);
	 * 
	 * @Query(
	 * value="select *from pub WHERE pub.location=:location AND pub.type=:type "
	 * ,nativeQuery=true) public List<General_Post> filterLocationType(@Param("location")
	 * String location,@Param("type") String type);
	 * 
	 * @Query(
	 * value="select *from pub WHERE pub.location=:location AND pub.categorie=:categorie "
	 * ,nativeQuery=true) public List<General_Post>
	 * filterLocationCategorie(@Param("location") String
	 * location,@Param("categorie") String categorie);
	 * 
	 * @Query(
	 * value="select *from pub WHERE pub.type=:type AND pub.categorie=:categorie"
	 * ,nativeQuery=true) public List<General_Post> filterTypeCategorie(@Param("type") String
	 * type,@Param("categorie") String categorie);
	 * 
	 * @Query(value="select *from pub WHERE pub.type='TASK'",nativeQuery=true)
	 * public List<General_Post> listerTasks();
	 * 
	 * @Query(value="select * from pub where offer.type='POST'",nativeQuery=true)
	 * public List<General_Post> listerPubs();
	 * 
	 * @Query(value="select * from pub ORDER BY date DESC",nativeQuery=true) public
	 * List<General_Post> listerAll();
	 */
}
