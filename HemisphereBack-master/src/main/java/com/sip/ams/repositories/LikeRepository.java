package com.sip.ams.repositories;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.Like;
@Repository("LikeRepository")
public interface LikeRepository  extends JpaRepository<Like, Long> {
	@Query(value="Select * from jaime where jaime.id=:id",nativeQuery=true)
	Like findLikeById(@Param("id") Long id);
	
	@Query(value="Select * from jaime where jaime.id_pub=:idpub And jaime.id_user=:iduser",nativeQuery=true)
	Like findByUserPub(@Param("iduser") Long iduser,@Param("idpub") Long idpub );
	
	@Query(value="Select count(jaime.id) from jaime where jaime.id_pub=:idpub",nativeQuery=true)
	int nlikes (@Param("idpub") Long idpub );
}
