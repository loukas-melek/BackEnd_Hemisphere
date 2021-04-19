package com.sip.ams.services;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Profile;
@Service
public interface ProfileService {
	Profile findByUserId( Integer id );
}
