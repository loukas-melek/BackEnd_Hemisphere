package com.sip.ams.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.Comment;


@Repository("CommentRepository")
public interface CommentRepository extends JpaRepository<Comment, Long>{
	/*
	 * @Query("select d from comment d where d.id=:id") 
	 * findCommentById(@Param("id")Long id);
	 */
@Query(value="select * from comment where comment.id_pub=:pub_id",nativeQuery=true)
	List<Comment>	getByPub(@Param("pub_id") Long pub_id);

@Query(value="Select count(comment.id) from comment where comment.id_pub=:idpub",nativeQuery=true)
int nComments (@Param("idpub") Long idpub );
}

