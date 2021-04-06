package com.sip.ams.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sip.ams.entities.Comment;


@Service
public interface CommentService {
	List<Comment> listerComments();
	Comment addComment(Comment comment);
	Comment updateComment(Long id,Comment comment);
	void deleteComment(Long id);
	List<Comment> listerCommentsByPub(Long id);
	int nComments (Long idpub );


}
