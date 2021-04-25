package com.sip.ams.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.Comment;
import com.sip.ams.services.CommentService;


@RestController
@RequestMapping({"/comment"})
@CrossOrigin
public class CommentController {
	@Autowired
	private CommentService commentService;
	@GetMapping("/list")
	 public List<Comment> getAllComments() {
	 return commentService.listerComments();
	 }
	@GetMapping("/list/{id}")
	 public List<Comment> getAllCommentsByPub(@PathVariable Long id) {
	 return commentService.listerCommentsByPub(id);
	 }
	@GetMapping("/count/{id}")
	 public int getCommentsNumber(@PathVariable Long id) {
	 return commentService.nComments(id);
	 }
	@PostMapping("/add")
	 public Comment createComment(@RequestBody Comment comment) {
		System.out.println(comment.getGeneral_Post().getId());
	  return commentService.addComment(comment);
	 }
	
	@PutMapping("update/{demandeId}")
	 public Comment updateComment(@PathVariable Long commentId, @Valid
	@RequestBody Comment cRequest) {
		 return commentService.updateComment(commentId, cRequest);
			 }
	 @DeleteMapping("delete/{demandeId}")
	 public void deleteComment(@PathVariable Long commentId) {
		 commentService.deleteComment(commentId);
	 }
}
