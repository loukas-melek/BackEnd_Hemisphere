//package com.sip.ams.controllers;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sip.ams.entities.users.Role;
//import com.sip.ams.services.RoleService;
//
//
//@RestController
//@RequestMapping({"/roles"})
//@CrossOrigin
//public class RoleController {
//	
//	@Autowired
//	private RoleService roleService;
//	@GetMapping("/list")
//	 public List<Role> getAllroles() {
//	 return (List<Role>) roleService.listerrole();
//	 }
//	@GetMapping("/{roleId}")
//	 public Role getRoleById(@PathVariable Long roleId) {
//	 return (Role) roleService.getRoleById(roleId);
//	 }
//	@PostMapping("/add")
//	 public void createRole( @RequestBody Role role) {
//	  roleService.addRole(role);
//	 }
//	@PutMapping("update/{roleId}")
//	 public Role updateRole(@PathVariable Long roleId, @Valid
//	@RequestBody Role roleRequest) {
//		 return roleService.updateRole(roleId, roleRequest);
//			 }
//	 @DeleteMapping("delete/{roleId}")
//	 public void deleteRole(@PathVariable Long roleId) {
//	 roleService.deleteRole(roleId);
//	 }
//    @GetMapping("userrole/{id}")
//    public Role getRole(@RequestParam("id")Long user_id) {
//        return roleService.getRoleByUserId(user_id);
//    }
//
//}
//
