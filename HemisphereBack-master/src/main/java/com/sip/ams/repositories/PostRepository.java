package com.sip.ams.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.Post;

@Repository("PostRepository")
public interface PostRepository extends JpaRepository<Post, Long>{
	
	
	 @Query(value= "select * from post ORDER BY id DESC", nativeQuery= true )
	 public List<Post> listerPosts();
	 

	}

