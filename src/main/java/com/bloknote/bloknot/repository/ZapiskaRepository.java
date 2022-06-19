package com.bloknote.bloknot.repository;

import com.bloknote.bloknot.model.Zapiska;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZapiskaRepository extends JpaRepository<Zapiska, Long> {
}
