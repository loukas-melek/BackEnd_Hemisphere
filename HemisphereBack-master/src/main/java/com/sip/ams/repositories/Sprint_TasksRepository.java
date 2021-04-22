package com.sip.ams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.Sprint_Tasks;

@Repository("Sprint_TasksRepository")
public interface Sprint_TasksRepository extends JpaRepository<Sprint_Tasks, Long> {

}
