package com.sip.ams.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByRole(String role);
	@Query (value= "select * from user_role WHERE user_role.user_id= :user_id", nativeQuery= true )
	public Long getRoleIdByUserId(@Param("user_id") Long user_id);
	
	@Query (value= "select * from role WHERE role.role_id= :role_id", nativeQuery= true )
	public Role getRoleById(@Param("role_id") Long role_id);
	
	
}
