package com.Geekster.Recipe.management.system.API.Repo;

import com.Geekster.Recipe.management.system.API.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Long> {
    User findFirstByUserEmail(String newEmail);
}
