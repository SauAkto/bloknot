package com.bloknote.bloknot.repository;

import com.bloknote.bloknot.model.Appeal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppealRepository extends JpaRepository<Appeal, Long> {
    List<Appeal> findByClient(String client);

}
