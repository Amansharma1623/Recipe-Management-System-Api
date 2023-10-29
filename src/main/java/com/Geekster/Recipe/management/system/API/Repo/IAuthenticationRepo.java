package com.Geekster.Recipe.management.system.API.Repo;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepo extends JpaRepository<Authentication, Long> {
}
