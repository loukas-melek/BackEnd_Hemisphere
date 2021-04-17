package com.sip.ams.entities;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
  ROLE_ADMIN, ROLE_STUDENT, ROLE_PREMIUM_STUDENT, ROLE_COMPANY, ROLE_PREMIUM_COMPANY;

  public String getAuthority() {
    return name();
  }

}
