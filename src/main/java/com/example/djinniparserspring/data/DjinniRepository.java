package com.example.djinniparserspring.data;

import com.example.djinniparserspring.entities.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DjinniRepository extends JpaRepository<Vacancy, String> {
}
