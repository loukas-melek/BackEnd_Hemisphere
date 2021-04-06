package com.sip.ams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.SharedPost;

@Repository("SharedPostRepository")
public interface SharedPostRepository extends JpaRepository<SharedPost, Long> {
	@Query(value="Select count(shared_post.id) from shared_post where shared_post.id_pub=:idpub",nativeQuery=true)
	int nShares (@Param("idpub") Long idpub );
}
