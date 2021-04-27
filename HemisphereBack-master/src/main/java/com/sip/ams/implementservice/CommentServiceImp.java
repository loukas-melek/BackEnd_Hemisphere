package com.sip.ams.implementservice;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Comment;
import com.sip.ams.repositories.CommentRepository;
import com.sip.ams.repositories.General_PostRepository;
import com.sip.ams.services.CommentService;
import com.sip.ams.services.General_PostService;
@Service
public class CommentServiceImp implements CommentService {
@Autowired
private CommentRepository commentRepository;
@Autowired
private General_PostService general_PostService;
	@Override
	public List<Comment> listerComments() {
		// TODO Auto-generated method stub
		return commentRepository.findAll();
	}

	@Override
	public Comment addComment(Comment comment) {
		// TODO Auto-generated method stub
		System.out.println("dkhalna lel add comment");
		System.out.println(comment.getGeneral_Post().getId());
		Date d = new Date();
		
		comment.setCreated_at(d);
		comment.setUpdated_at(d);
		System.out.println(comment.getCreated_at());

		return commentRepository.save(comment);
		 
		  
	}

	@Override
	public Comment updateComment(Long id, Comment comment) {
		// TODO Auto-generated method stub
		Comment oldComment=commentRepository.getOne(id);
		if(oldComment!=null) {
			oldComment.setContent(comment.getContent());
			oldComment.setProfile(comment.getProfile());
			commentRepository.save(oldComment);
		}
		return oldComment;
	}

	@Override
	public void deleteComment(Long id) {
		// TODO Auto-generated method stub
		commentRepository.deleteById(id);
	}

	@Override
	public List<Comment> listerCommentsByPub(Long id) {
		// TODO Auto-generated method stub
		return commentRepository.getByPub(id);
	}

	@Override
	public int nComments(Long idpub) {
		// TODO Auto-generated method stub
		return commentRepository.nComments(idpub);
	}

	@Override
	public List<Comment> getComments() {
		// TODO Auto-generated method stub
		return commentRepository.getComments();
	}

	@Override
	public List<Comment> getReplies(Long id) {
		
		return commentRepository.getReplies(id);
	}

}
