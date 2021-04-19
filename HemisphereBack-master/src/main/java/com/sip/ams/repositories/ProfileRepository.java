package com.sip.ams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.sip.ams.entities.Profile;

public interface ProfileRepository  extends JpaRepository<Profile, Long> {

	@Query(value="Select * from profile where profile.user_id=:id",nativeQuery=true)
	Profile findByUserId(@Param("id") Integer id );
}
