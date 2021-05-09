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

        Project p= projectrepository.save(project);
        
        return p;
    }

	@Override
	public void saveOrUpdate(Project project,Long project_id) {
		Project projec=projectrepository.findById(project_id).get();
		System.out.println(projec.toString());
		projec.setDescription(project.getDescription());
		projec.setEnd_date(project.getEnd_date());
		projec.setIs_active(project.getIs_active());
		projec.setStart_date(project.getStart_date());
		projec.setTitle(project.getTitle());
		project.setProfile(project.getProfile());
		 projectrepository.save(project);
	}

	
	@Override
	public void delete(Long project_id) {
		projectrepository.deleteById(project_id);
	}
	 void sendEmail(Profile p,Project project) {
		 System.out.println(project.getGeneralpost().getOffertasksolution().getOffer_type());
	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(p.getEmail());

	        msg.setSubject("Response following an application approval ["+ project.getGeneralpost().getOffertasksolution().getOffer_type()+"]");
	        msg.setText("Hello "+ p.getLastname() +" "+ p.getName()+",\n\n"+"Thank you again for your time, we highly appreciate your commitment." + 
	        		"\n" + 
	        		"\nWe are happy to inform you that you have obtained "+ project.getProfile().getLastname()+" " + project.getProfile().getName() +"'s approval on the "+" <<"+project.getTitle()+">> "+"project and we look forward to welcome you to the project team.\n"
	        				+ "\nTo see your tasks and start working, join the hemisphere by clicking on this link: http://localhost:4200/student/workflow\n\nRegards,\r\n" + 
	        				"\r\n" + 
	        				"Support team. \r\n" + 
	        				"\r\n" + 
	        				"Hemisphere.com.tn" );

	        javaMailSender.send(msg);

	    }

	@Override
	public void ConfirmProject(Long proj_id,List<Profile> students) {
		// TODO Auto-generated method stub
		System.out.println("we are in the implementation");
		Project p =projectrepository.getOne(proj_id);
		System.out.println(proj_id);
		System.out.println(students);
		System.out.println(students.size());
		for(int i = 0;i<students.size();i++) {
			System.out.println(students.get(i).getEmail());
			System.out.println(students.get(i).getId());
			System.out.println(proj_id);
			projectrepository.ConfirmProject(proj_id,students.get(i).getId());
			System.out.println("kamalna el save lel base");
			this.sendEmail(students.get(i),p);
		}
	}

	@Override
	public ProjectDto findByGeneralPostId(Long id) {
		Project retour =projectrepository.findByGeneralPostId(id);
		return converter.convertProjectToDto(retour);
	}

	

	@Override
	public List<ProjectDto> findByStudentId(Long id) {
		List<Project> retourList= new ArrayList<Project>();
		List<Long> listIds=projectrepository.FindByStudent(id);
		for(int i=0;i<listIds.size();i++) {
			retourList.add(projectrepository.getOne(listIds.get(i)));
		}
		return converter.convertListProjectToDto(retourList);
	}

	@Override
	public List<ProjectDto> FindByCompany(Long id) {
		List<Project> retourList= projectrepository.FindByCompany(id);
		return converter.convertListProjectToDto(retourList);
	}
}
