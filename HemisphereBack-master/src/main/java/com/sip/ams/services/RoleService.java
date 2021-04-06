package com.sip.ams.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.sip.ams.entities.Role;
@Service
public interface RoleService {
	
	public Long getRoleIdByUserId(Long user_id);
	public Role getRoleById(Long role_id);
	public Role getRoleByUserId(Long user_id);
	public List<Role> listerrole();
	public void addRole(Role role);
	public Role updateRole(Long roleId, @Valid Role roleRequest);
	public void deleteRole(Long roleId);
}
