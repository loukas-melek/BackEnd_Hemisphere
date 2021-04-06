package com.sip.ams.implementservice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Role;
import com.sip.ams.repositories.RoleRepository;
import com.sip.ams.services.RoleService;
@Service

public class RoleServiceImp implements RoleService {
	@Autowired
	private RoleRepository rolerepository;
	
	@Override
	public Long getRoleIdByUserId(Long user_id){
		return rolerepository.getRoleIdByUserId(user_id);
	}
	@Override
	public Role getRoleById(Long role_id) {
		
		return rolerepository.getRoleById(role_id);
	}
	@Override
	public Role getRoleByUserId(Long user_id) {
		Long role_id=getRoleIdByUserId(user_id);
		return getRoleById(role_id);
	}
	@Override
	public List<Role> listerrole() {
		
		return rolerepository.findAll();
	}
	@Override
	public void addRole(Role role) {
		rolerepository.save(role);
		
	}
	@Override
	public Role updateRole(Long roleId, @Valid Role roleRequest) {
		Role oldrole=rolerepository.getRoleById(roleId);
		if(oldrole!=null) {
			oldrole.setRole(roleRequest.getRole());
		}
		return oldrole;
	}
	@Override
	public void deleteRole(Long roleId) {
		rolerepository.deleteById(roleId);
		
	}
	
}
