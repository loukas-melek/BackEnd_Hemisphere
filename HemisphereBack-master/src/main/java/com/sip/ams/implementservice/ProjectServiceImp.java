package com.sip.ams.implementservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sip.ams.converts.ProjectConverter;
import com.sip.ams.dto.ProjectDto;
import com.sip.ams.entities.Profile;
import com.sip.ams.entities.Project;
import com.sip.ams.repositories.ProfileRepository;
import com.sip.ams.repositories.ProjectRepository;
import com.sip.ams.services.ProjectService;

@Service
public class ProjectServiceImp implements ProjectService{
	@Autowired  
	ProjectRepository projectrepository;
	@Autowired  
	ProfileRepository profilerepository;
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	private ProjectConverter converter;
	
	@Override
	public List<ProjectDto> getAllProjects() {
		List<Project> pro = new ArrayList<>();
		pro = projectrepository.findAll();
        return converter.convertListProjectToDto(pro);
	}

	@Override
	public Project getProjectById(Long project_id) {
		return  projectrepository.findById(project_id).get(); 
	}
	
	@Override
    public Project insert(Project project) {
		project.setCreated_at(new Date());
		project.setUpdated_at(new Date());
        Project p= projectrepository.save(project);
        
        return p;
    }

	@Override
	public void saveOrUpdate(Project project,Long project_id) {
		Project projec=projectrepository.findById(project_id).get();
		System.out.println(projec.toString());
		projec.setCreated_at(project.getCreated_at());
		projec.setDescription(project.getDescription());
		projec.setEnd_date(project.getEnd_date());
		projec.setIs_active(project.getIs_active());
		projec.setStart_date(project.getStart_date());
		projec.setTitle(project.getTitle());
		projec.setUpdated_at(projec.getUpdated_at());
		project.setProfile(project.getProfile());
		 projectrepository.save(project);
	}

	
	@Override
	public void delete(Long project_id) {
		projectrepository.deleteById(project_id);
	}
	 void sendEmail(Profile p) {

	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(p.getEmail());

	        msg.setSubject("Testing from Spring Boot");
	        msg.setText("Hello World \n Spring Boot Email");

	        javaMailSender.send(msg);

	    }

	@Override
	public void ConfirmProject(Long proj_id,List<Profile> students) {
		// TODO Auto-generated method stub
		System.out.println("we are in the implementation");
		System.out.println(proj_id);
		System.out.println(students);
		System.out.println(students.size());
		for(int i = 0;i<students.size();i++) {
			System.out.println(students.get(i).getEmail());
			System.out.println(students.get(i).getId());
			System.out.println(proj_id);
			projectrepository.ConfirmProject(proj_id,students.get(i).getId());
			System.out.println("kamalna el save lel base");
			this.sendEmail(students.get(i));
		}
	}

	@Override
	public Project findByGeneralPostId(Long id) {
		// TODO Auto-generated method stub
		return projectrepository.findByGeneralPostId(id);
	}

	

	@Override
	public List<Project> findByStudentId(Long id) {
		List<Project> retourList= new ArrayList<Project>();
		List<Long> listIds=projectrepository.FindByStudent(id);
		for(int i=0;i<listIds.size();i++) {
			retourList.add(projectrepository.getOne(listIds.get(i)));
		}
		return retourList;
	}
}
