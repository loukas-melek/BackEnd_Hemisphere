package com.sip.ams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.User;



@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    
	//@Query (value= "select * from user WHERE user.email='malek@gmail.com'", nativeQuery= true )
	User findByEmail(String user_email);
    
	@Query (value= "SELECT * from user WHERE user.user_id= :id", nativeQuery= true )
	User getById(@Param("id")Long id);
	
	@Query (value= "SELECT role_id from user_role WHERE user_role.user_id= :id", nativeQuery= true )
	Long getUserRoleId(@Param("id")Long id);
	
	
	
	

}
