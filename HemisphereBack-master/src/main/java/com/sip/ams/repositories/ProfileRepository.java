package com.sip.ams.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sip.ams.entities.Profile;

public interface ProfileRepository  extends JpaRepository<Profile, Long> {

}
