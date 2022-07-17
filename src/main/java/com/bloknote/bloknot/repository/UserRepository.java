package com.bloknote.bloknot.repository;

import com.bloknote.bloknot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);

}
